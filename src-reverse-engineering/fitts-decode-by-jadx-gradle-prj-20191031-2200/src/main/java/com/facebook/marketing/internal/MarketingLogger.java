package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public final class MarketingLogger {
    private final AppEventsLogger appEventsLogger;

    public MarketingLogger(Context context, String str) {
        this.appEventsLogger = AppEventsLogger.newLogger(context, str);
    }

    public void logCodelessInitialized() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "sdk_initialized");
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }

    public void logGestureTriggered() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "gesture_triggered");
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }

    public void logSessionReady() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "session_ready");
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }

    public void logIndexingStart(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "indexing_start");
            bundle.putString("_activity_name", str);
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }

    public void logIndexingComplete(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "indexing_complete");
            bundle.putString("_activity_name", str);
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }

    public void logIndexingCancelled(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "indexing_cancelled");
            bundle.putString("_activity_name", str);
            this.appEventsLogger.logSdkEvent("fb_codeless_debug", null, bundle);
        }
    }
}
