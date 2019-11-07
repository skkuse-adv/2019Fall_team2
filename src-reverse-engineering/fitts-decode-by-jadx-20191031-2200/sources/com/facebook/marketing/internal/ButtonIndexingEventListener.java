package com.facebook.marketing.internal;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate;
import com.facebook.appevents.codeless.internal.ViewHierarchy;

public class ButtonIndexingEventListener {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.marketing.internal.ButtonIndexingEventListener";

    public static class ButtonIndexingAccessibilityDelegate extends AutoLoggingAccessibilityDelegate {
        @Nullable
        private AccessibilityDelegate existingDelegate;
        private String mapKey;

        public ButtonIndexingAccessibilityDelegate(View view, String str) {
            if (view != null) {
                this.existingDelegate = ViewHierarchy.getExistingDelegate(view);
                this.mapKey = str;
                this.supportButtonIndexing = true;
            }
        }

        public void sendAccessibilityEvent(final View view, int i) {
            if (i == -1) {
                ButtonIndexingEventListener.TAG;
            }
            AccessibilityDelegate accessibilityDelegate = this.existingDelegate;
            if (accessibilityDelegate != null && !(accessibilityDelegate instanceof ButtonIndexingAccessibilityDelegate)) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            }
            final String str = this.mapKey;
            FacebookSdk.getExecutor().execute(new Runnable(this) {
                public void run() {
                    ButtonIndexingLogger.logIndexing(FacebookSdk.getApplicationId(), view, str, FacebookSdk.getApplicationContext());
                }
            });
        }
    }

    public static ButtonIndexingAccessibilityDelegate getAccessibilityDelegate(View view, String str) {
        return new ButtonIndexingAccessibilityDelegate(view, str);
    }
}
