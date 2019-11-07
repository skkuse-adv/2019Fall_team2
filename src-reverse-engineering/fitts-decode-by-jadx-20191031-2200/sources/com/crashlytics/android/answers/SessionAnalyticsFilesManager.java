package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.UUID;

class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private AnalyticsSettingsData analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage) throws IOException {
        super(context, sessionEventTransform, currentTimeProvider, eventsStorage, 100);
    }

    /* access modifiers changed from: protected */
    public String generateUniqueRollOverFileName() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(SESSION_ANALYTICS_TO_SEND_FILE_PREFIX);
        String str = "_";
        sb.append(str);
        sb.append(randomUUID.toString());
        sb.append(str);
        sb.append(this.currentTimeProvider.getCurrentTimeMillis());
        sb.append(SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public int getMaxFilesToKeep() {
        AnalyticsSettingsData analyticsSettingsData2 = this.analyticsSettingsData;
        return analyticsSettingsData2 == null ? super.getMaxFilesToKeep() : analyticsSettingsData2.maxPendingSendFileCount;
    }

    /* access modifiers changed from: protected */
    public int getMaxByteSizePerFile() {
        AnalyticsSettingsData analyticsSettingsData2 = this.analyticsSettingsData;
        return analyticsSettingsData2 == null ? super.getMaxByteSizePerFile() : analyticsSettingsData2.maxByteSizePerFile;
    }

    /* access modifiers changed from: 0000 */
    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData2) {
        this.analyticsSettingsData = analyticsSettingsData2;
    }
}
