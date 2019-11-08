package kr.co.popone.fitts.feature.feeds;

import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

final class SlidingBannerFeedHolder$startBannerPolling$4<T> implements Consumer<Integer> {
    final /* synthetic */ SlidingBannerFeedHolder this$0;

    SlidingBannerFeedHolder$startBannerPolling$4(SlidingBannerFeedHolder slidingBannerFeedHolder) {
        this.this$0 = slidingBannerFeedHolder;
    }

    public final void accept(Integer num) {
        RecyclerView access$getBannerSlider$p = this.this$0.bannerSlider;
        Intrinsics.checkExpressionValueIsNotNull(num, "pos");
        access$getBannerSlider$p.smoothScrollToPosition(num.intValue());
        StringBuilder sb = new StringBuilder();
        sb.append("SlidingBannerFeedHolder::PollingPosition = ");
        sb.append(num);
        Logger.d(sb.toString(), new Object[0]);
    }
}
