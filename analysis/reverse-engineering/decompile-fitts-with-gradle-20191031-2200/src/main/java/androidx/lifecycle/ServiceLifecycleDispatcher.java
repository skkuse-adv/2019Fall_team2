package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;

public class ServiceLifecycleDispatcher {
    private final Handler mHandler = new Handler();
    private DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    static class DispatchRunnable implements Runnable {
        final Event mEvent;
        private final LifecycleRegistry mRegistry;
        private boolean mWasExecuted = false;

        DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Event event) {
            this.mRegistry = lifecycleRegistry;
            this.mEvent = event;
        }

        public void run() {
            if (!this.mWasExecuted) {
                this.mRegistry.handleLifecycleEvent(this.mEvent);
                this.mWasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.mRegistry = new LifecycleRegistry(lifecycleOwner);
    }

    private void postDispatchRunnable(Event event) {
        DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        this.mLastDispatchRunnable = new DispatchRunnable(this.mRegistry, event);
        this.mHandler.postAtFrontOfQueue(this.mLastDispatchRunnable);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Event.ON_CREATE);
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Event.ON_START);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Event.ON_START);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Event.ON_STOP);
        postDispatchRunnable(Event.ON_DESTROY);
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
