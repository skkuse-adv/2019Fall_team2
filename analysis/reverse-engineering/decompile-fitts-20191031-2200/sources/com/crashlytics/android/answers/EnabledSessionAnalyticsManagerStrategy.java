package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    ApiKey apiKey = new ApiKey();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    FilesSender filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    private final HttpRequestFactory httpRequestFactory;
    boolean includePurchaseEventsInForwardedEvents = false;
    private final Kit kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit2, Context context2, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory2, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter2) {
        this.kit = kit2;
        this.context = context2;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = httpRequestFactory2;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter2;
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        SessionAnalyticsFilesSender sessionAnalyticsFilesSender = new SessionAnalyticsFilesSender(this.kit, str, analyticsSettingsData.analyticsURL, this.httpRequestFactory, this.apiKey.getValue(this.context));
        this.filesSender = AnswersRetryFilesSender.build(sessionAnalyticsFilesSender);
        this.filesManager.setAnalyticsSettingsData(analyticsSettingsData);
        this.forwardToFirebaseAnalyticsEnabled = analyticsSettingsData.forwardToFirebaseAnalytics;
        this.includePurchaseEventsInForwardedEvents = analyticsSettingsData.includePurchaseEventsInForwardedEvents;
        Logger logger = Fabric.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        String str2 = "enabled";
        String str3 = "disabled";
        sb.append(this.forwardToFirebaseAnalyticsEnabled ? str2 : str3);
        String sb2 = sb.toString();
        String str4 = Answers.TAG;
        logger.d(str4, sb2);
        Logger logger2 = Fabric.getLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Firebase analytics including purchase events ");
        sb3.append(this.includePurchaseEventsInForwardedEvents ? str2 : str3);
        logger2.d(str4, sb3.toString());
        this.customEventsEnabled = analyticsSettingsData.trackCustomEvents;
        Logger logger3 = Fabric.getLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Custom event tracking ");
        sb4.append(this.customEventsEnabled ? str2 : str3);
        logger3.d(str4, sb4.toString());
        this.predefinedEventsEnabled = analyticsSettingsData.trackPredefinedEvents;
        Logger logger4 = Fabric.getLogger();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Predefined event tracking ");
        if (!this.predefinedEventsEnabled) {
            str2 = str3;
        }
        sb5.append(str2);
        logger4.d(str4, sb5.toString());
        if (analyticsSettingsData.samplingRate > 1) {
            Fabric.getLogger().d(str4, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(analyticsSettingsData.samplingRate);
        }
        this.rolloverIntervalSeconds = analyticsSettingsData.flushIntervalSeconds;
        scheduleTimeBasedFileRollOver(0, (long) this.rolloverIntervalSeconds);
    }

    public void processEvent(Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        boolean z = this.customEventsEnabled;
        String str = Answers.TAG;
        if (!z && Type.CUSTOM.equals(build.type)) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Custom events tracking disabled - skipping event: ");
            sb.append(build);
            logger.d(str, sb.toString());
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(build.type)) {
            Logger logger2 = Fabric.getLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Predefined events tracking disabled - skipping event: ");
            sb2.append(build);
            logger2.d(str, sb2.toString());
        } else if (this.eventFilter.skipEvent(build)) {
            Logger logger3 = Fabric.getLogger();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping filtered event: ");
            sb3.append(build);
            logger3.d(str, sb3.toString());
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (IOException e) {
                Logger logger4 = Fabric.getLogger();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to write event: ");
                sb4.append(build);
                logger4.e(str, sb4.toString(), e);
            }
            scheduleTimeBasedRollOverIfNeeded();
            boolean z2 = Type.CUSTOM.equals(build.type) || Type.PREDEFINED.equals(build.type);
            boolean equals = "purchase".equals(build.predefinedType);
            if (this.forwardToFirebaseAnalyticsEnabled && z2 && (!equals || this.includePurchaseEventsInForwardedEvents)) {
                try {
                    this.firebaseAnalyticsApiAdapter.processEvent(build);
                } catch (Exception e2) {
                    Logger logger5 = Fabric.getLogger();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Failed to map event to Firebase: ");
                    sb5.append(build);
                    logger5.e(str, sb5.toString(), e2);
                }
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        if (this.filesSender == null) {
            CommonUtils.logControlled(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.logControlled(this.context, "Sending all files");
        List batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (true) {
            try {
                if (batchOfFilesToSend.size() <= 0) {
                    break;
                }
                CommonUtils.logControlled(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Exception e) {
                Context context2 = this.context;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to send batch of analytics files to server: ");
                sb.append(e.getMessage());
                CommonUtils.logControlledError(context2, sb.toString(), e);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.logControlled(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.context, this);
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling time based file roll over every ");
            sb.append(j2);
            sb.append(" seconds");
            CommonUtils.logControlled(context2, sb.toString());
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.logControlledError(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
