package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class FirebaseAnalyticsApiAdapter {
    private final Context context;
    private EventLogger eventLogger;
    private final FirebaseAnalyticsEventMapper eventMapper;

    public FirebaseAnalyticsApiAdapter(Context context2) {
        this(context2, new FirebaseAnalyticsEventMapper());
    }

    public FirebaseAnalyticsApiAdapter(Context context2, FirebaseAnalyticsEventMapper firebaseAnalyticsEventMapper) {
        this.context = context2;
        this.eventMapper = firebaseAnalyticsEventMapper;
    }

    public EventLogger getFirebaseAnalytics() {
        if (this.eventLogger == null) {
            this.eventLogger = AppMeasurementEventLogger.getEventLogger(this.context);
        }
        return this.eventLogger;
    }

    public void processEvent(SessionEvent sessionEvent) {
        EventLogger firebaseAnalytics = getFirebaseAnalytics();
        String str = Answers.TAG;
        if (firebaseAnalytics == null) {
            Fabric.getLogger().d(str, "Firebase analytics logging was enabled, but not available...");
            return;
        }
        FirebaseAnalyticsEvent mapEvent = this.eventMapper.mapEvent(sessionEvent);
        if (mapEvent == null) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Fabric event was not mappable to Firebase event: ");
            sb.append(sessionEvent);
            logger.d(str, sb.toString());
            return;
        }
        firebaseAnalytics.logEvent(mapEvent.getEventName(), mapEvent.getEventParams());
        if ("levelEnd".equals(sessionEvent.predefinedType)) {
            firebaseAnalytics.logEvent("post_score", mapEvent.getEventParams());
        }
    }
}
