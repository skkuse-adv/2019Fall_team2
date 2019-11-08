package org.simple.eventbus.handler;

import android.os.Handler;
import android.os.HandlerThread;
import org.simple.eventbus.Subscription;

public class AsyncEventHandler implements EventHandler {
    DispatcherThread mDispatcherThread = new DispatcherThread(AsyncEventHandler.class.getSimpleName());
    EventHandler mEventHandler = new DefaultEventHandler();

    class DispatcherThread extends HandlerThread {
        protected Handler mAsyncHandler;

        public DispatcherThread(String str) {
            super(str);
        }

        public void post(Runnable runnable) {
            Handler handler = this.mAsyncHandler;
            if (handler != null) {
                handler.post(runnable);
                return;
            }
            throw new NullPointerException("mAsyncHandler == null, please call start() first.");
        }

        public synchronized void start() {
            super.start();
            this.mAsyncHandler = new Handler(getLooper());
        }
    }

    public AsyncEventHandler() {
        this.mDispatcherThread.start();
    }

    public void handleEvent(final Subscription subscription, final Object obj) {
        this.mDispatcherThread.post(new Runnable() {
            public void run() {
                AsyncEventHandler.this.mEventHandler.handleEvent(subscription, obj);
            }
        });
    }
}
