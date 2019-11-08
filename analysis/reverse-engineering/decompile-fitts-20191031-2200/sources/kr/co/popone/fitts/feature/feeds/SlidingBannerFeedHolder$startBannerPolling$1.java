package kr.co.popone.fitts.feature.feeds;

import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.extension.SnapHelperExtensionKt;
import org.jetbrains.annotations.NotNull;

final class SlidingBannerFeedHolder$startBannerPolling$1<T, R> implements Function<T, R> {
    final /* synthetic */ SlidingBannerFeedHolder this$0;

    SlidingBannerFeedHolder$startBannerPolling$1(SlidingBannerFeedHolder slidingBannerFeedHolder) {
        this.this$0 = slidingBannerFeedHolder;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((Long) obj));
    }

    public final int apply(@NotNull Long l) {
        Intrinsics.checkParameterIsNotNull(l, "it");
        PagerSnapHelper access$getSlideSanpHelper$p = this.this$0.slideSanpHelper;
        RecyclerView access$getBannerSlider$p = this.this$0.bannerSlider;
        Intrinsics.checkExpressionValueIsNotNull(access$getBannerSlider$p, "bannerSlider");
        return SnapHelperExtensionKt.getSnapPosition(access$getSlideSanpHelper$p, access$getBannerSlider$p);
    }
}
