package org.simple.eventbus.handler;

import android.os.Handler;
import android.os.Looper;
import org.simple.eventbus.Subscription;

public class UIThreadEventHandler implements EventHandler {
    DefaultEventHandler mEventHandler = new DefaultEventHandler();
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public void handleEvent(final Subscription subscription, final Object obj) {
        this.mUIHandler.post(new Runnable() {
            public void run() {
                UIThreadEventHandler.this.mEventHandler.handleEvent(subscription, obj);
            }
        });
    }
}
