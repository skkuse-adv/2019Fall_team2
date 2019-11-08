package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.internal.Logger;
import java.io.Serializable;
import java.util.Locale;

class FacebookTimeSpentData implements Serializable {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String TAG = FacebookTimeSpentData.class.getCanonicalName();
    private static final long serialVersionUID = 1;
    private String firstOpenSourceApplication;
    private int interruptionCount;
    private boolean isAppActive;
    private boolean isWarmLaunch;
    private long lastActivateEventLoggedTime;
    private long lastResumeTime;
    private long lastSuspendTime;
    private long millisecondsSpentInSession;

    private static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 6;
        private final String firstOpenSourceApplication;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV2(long j, long j2, long j3, int i, String str) {
            this.lastResumeTime = j;
            this.lastSuspendTime = j2;
            this.millisecondsSpentInSession = j3;
            this.interruptionCount = i;
            this.firstOpenSourceApplication = str;
        }

        private Object readResolve() {
            FacebookTimeSpentData facebookTimeSpentData = new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
            return facebookTimeSpentData;
        }
    }

    FacebookTimeSpentData() {
        resetSession();
    }

    private FacebookTimeSpentData(long j, long j2, long j3, int i, String str) {
        resetSession();
        this.lastResumeTime = j;
        this.lastSuspendTime = j2;
        this.millisecondsSpentInSession = j3;
        this.interruptionCount = i;
        this.firstOpenSourceApplication = str;
    }

    private Object writeReplace() {
        SerializationProxyV2 serializationProxyV2 = new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
        return serializationProxyV2;
    }

    /* access modifiers changed from: 0000 */
    public void onSuspend(AppEventsLogger appEventsLogger, long j) {
        if (!this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
            return;
        }
        long j2 = j - this.lastResumeTime;
        if (j2 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
            j2 = 0;
        }
        this.millisecondsSpentInSession += j2;
        this.lastSuspendTime = j;
        this.isAppActive = false;
    }

    /* access modifiers changed from: 0000 */
    public void onResume(AppEventsLogger appEventsLogger, long j, String str) {
        if (isColdLaunch() || j - this.lastActivateEventLoggedTime > 300000) {
            Bundle bundle = new Bundle();
            bundle.putString("fb_mobile_launch_source", str);
            appEventsLogger.logEvent("fb_mobile_activate_app", bundle);
            this.lastActivateEventLoggedTime = j;
            if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                appEventsLogger.flush();
            }
        }
        if (this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
            return;
        }
        long j2 = 0;
        long j3 = wasSuspendedEver() ? j - this.lastSuspendTime : 0;
        if (j3 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        } else {
            j2 = j3;
        }
        if (j2 > 60000) {
            logAppDeactivatedEvent(appEventsLogger, j2);
        } else if (j2 > 1000) {
            this.interruptionCount++;
        }
        if (this.interruptionCount == 0) {
            this.firstOpenSourceApplication = str;
        }
        this.lastResumeTime = j;
        this.isAppActive = true;
    }

    private void logAppDeactivatedEvent(AppEventsLogger appEventsLogger, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", this.interruptionCount);
        String str = "fb_mobile_time_between_sessions";
        bundle.putString(str, String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(getQuantaIndex(j))}));
        bundle.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
        appEventsLogger.logEvent("fb_mobile_deactivate_app", (double) (this.millisecondsSpentInSession / 1000), bundle);
        resetSession();
    }

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    private void resetSession() {
        this.isAppActive = false;
        this.lastResumeTime = -1;
        this.lastSuspendTime = -1;
        this.interruptionCount = 0;
        this.millisecondsSpentInSession = 0;
    }

    private boolean wasSuspendedEver() {
        return this.lastSuspendTime != -1;
    }

    private boolean isColdLaunch() {
        boolean z = !this.isWarmLaunch;
        this.isWarmLaunch = true;
        return z;
    }
}
