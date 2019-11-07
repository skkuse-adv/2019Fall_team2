package kr.co.popone.fitts.feature.feeds;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class SlidingBannerFeedHolder_LifecycleAdapter implements GeneratedAdapter {
    final SlidingBannerFeedHolder mReceiver;

    SlidingBannerFeedHolder_LifecycleAdapter(SlidingBannerFeedHolder slidingBannerFeedHolder) {
        this.mReceiver = slidingBannerFeedHolder;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            if (event == Event.ON_PAUSE) {
                if (!z2 || methodCallsLogger.approveCall("pauseSlidingBanner", 1)) {
                    this.mReceiver.pauseSlidingBanner();
                }
                return;
            }
            if (event == Event.ON_RESUME && (!z2 || methodCallsLogger.approveCall("resumeSlidingBanner", 1))) {
                this.mReceiver.resumeSlidingBanner();
            }
        }
    }
}
