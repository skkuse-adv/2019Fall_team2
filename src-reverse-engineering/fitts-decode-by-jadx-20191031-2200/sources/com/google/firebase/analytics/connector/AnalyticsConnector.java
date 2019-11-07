package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalyticsConnector {

    public interface AnalyticsConnectorHandle {
        void registerEventNames(Set<String> set);

        void unregister();

        void unregisterEventNames();
    }

    public interface AnalyticsConnectorListener {
        void onMessageTriggered(int i, @Nullable Bundle bundle);
    }

    public static class ConditionalUserProperty {
        public boolean active;
        public long creationTimestamp;
        public String expiredEventName;
        public Bundle expiredEventParams;
        public String name;
        public String origin;
        public long timeToLive;
        public String timedOutEventName;
        public Bundle timedOutEventParams;
        public String triggerEventName;
        public long triggerTimeout;
        public String triggeredEventName;
        public Bundle triggeredEventParams;
        public long triggeredTimestamp;
        public Object value;
    }

    void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle);

    @WorkerThread
    List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @Nullable String str2);

    @WorkerThread
    int getMaxUserProperties(@Size(min = 1) @NonNull String str);

    @WorkerThread
    Map<String, Object> getUserProperties(boolean z);

    void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle);

    AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnectorListener analyticsConnectorListener);

    void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty);

    void setUserProperty(@NonNull String str, @NonNull String str2, Object obj);
}
