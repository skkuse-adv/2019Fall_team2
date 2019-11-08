package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;

public class RCTCodelessLoggingEventListener {

    public static class AutoLoggingOnTouchListener implements OnTouchListener {
        @Nullable
        private OnTouchListener existingOnTouchListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging = false;

        public AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
            if (eventBinding != null && view != null && view2 != null) {
                this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
                this.mapping = eventBinding;
                this.hostView = new WeakReference<>(view2);
                this.rootView = new WeakReference<>(view);
                this.supportCodelessLogging = true;
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                logEvent();
            }
            OnTouchListener onTouchListener = this.existingOnTouchListener;
            if (onTouchListener == null || !onTouchListener.onTouch(view, motionEvent)) {
                return false;
            }
            return true;
        }

        private void logEvent() {
            EventBinding eventBinding = this.mapping;
            if (eventBinding != null) {
                final String eventName = eventBinding.getEventName();
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
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }

    public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingOnTouchListener(eventBinding, view, view2);
    }
}
