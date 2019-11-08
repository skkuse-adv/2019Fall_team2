package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.EventBinding.ActionType;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;

public class CodelessLoggingEventListener {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.codeless.CodelessLoggingEventListener";

    /* renamed from: com.facebook.appevents.codeless.CodelessLoggingEventListener$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType = new int[ActionType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.facebook.appevents.codeless.internal.EventBinding$ActionType[] r0 = com.facebook.appevents.codeless.internal.EventBinding.ActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType = r0
                int[] r0 = $SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.appevents.codeless.internal.EventBinding$ActionType r1 = com.facebook.appevents.codeless.internal.EventBinding.ActionType.CLICK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.appevents.codeless.internal.EventBinding$ActionType r1 = com.facebook.appevents.codeless.internal.EventBinding.ActionType.SELECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.appevents.codeless.internal.EventBinding$ActionType r1 = com.facebook.appevents.codeless.internal.EventBinding.ActionType.TEXT_CHANGED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessLoggingEventListener.AnonymousClass1.<clinit>():void");
        }
    }

    public static class AutoLoggingAccessibilityDelegate extends AccessibilityDelegate {
        private int accessibilityEventType;
        private AccessibilityDelegate existingDelegate;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        protected boolean supportButtonIndexing = false;
        private boolean supportCodelessLogging = false;

        public AutoLoggingAccessibilityDelegate() {
        }

        public AutoLoggingAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
            if (eventBinding != null && view != null && view2 != null) {
                this.existingDelegate = ViewHierarchy.getExistingDelegate(view2);
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(view2);
                this.rootView = new WeakReference<>(view);
                ActionType type = eventBinding.getType();
                int i = AnonymousClass1.$SwitchMap$com$facebook$appevents$codeless$internal$EventBinding$ActionType[eventBinding.getType().ordinal()];
                if (i == 1) {
                    this.accessibilityEventType = 1;
                } else if (i == 2) {
                    this.accessibilityEventType = 4;
                } else if (i == 3) {
                    this.accessibilityEventType = 16;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported action type: ");
                    sb.append(type.toString());
                    throw new FacebookException(sb.toString());
                }
                this.supportCodelessLogging = true;
            }
        }

        public void sendAccessibilityEvent(View view, int i) {
            if (i == -1) {
                CodelessLoggingEventListener.TAG;
            }
            if (i == this.accessibilityEventType) {
                AccessibilityDelegate accessibilityDelegate = this.existingDelegate;
                if (accessibilityDelegate != null && !(accessibilityDelegate instanceof AutoLoggingAccessibilityDelegate)) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                }
                logEvent();
            }
        }

        private void logEvent() {
            final String eventName = this.mapping.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, (View) this.rootView.get(), (View) this.hostView.get());
            String str = "_valueToSum";
            if (parameters.containsKey(str)) {
                parameters.putDouble(str, AppEventUtility.normalizePrice(parameters.getString(str)));
            }
            parameters.putString("_is_fb_codeless", "1");
            FacebookSdk.getExecutor().execute(new Runnable(this) {
                public void run() {
                    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                }
            });
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        public boolean getSupportButtonIndexing() {
            return this.supportButtonIndexing;
        }
    }

    public static AutoLoggingAccessibilityDelegate getAccessibilityDelegate(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingAccessibilityDelegate(eventBinding, view, view2);
    }
}
