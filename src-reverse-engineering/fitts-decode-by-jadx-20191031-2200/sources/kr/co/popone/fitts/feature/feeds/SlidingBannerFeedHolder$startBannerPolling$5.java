package kr.co.popone.fitts.feature.feeds;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class SlidingBannerFeedHolder$startBannerPolling$5<T> implements Consumer<Throwable> {
    public static final SlidingBannerFeedHolder$startBannerPolling$5 INSTANCE = new SlidingBannerFeedHolder$startBannerPolling$5();

    SlidingBannerFeedHolder$startBannerPolling$5() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("SlidingBannerFeedHolder::");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
