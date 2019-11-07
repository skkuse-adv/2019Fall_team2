package kr.co.popone.fitts.feature.feeds;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class SlidingBannerFeedHolder$startBannerPolling$3<T, R> implements Function<T, R> {
    public static final SlidingBannerFeedHolder$startBannerPolling$3 INSTANCE = new SlidingBannerFeedHolder$startBannerPolling$3();

    SlidingBannerFeedHolder$startBannerPolling$3() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((Integer) obj));
    }

    public final int apply(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return num.intValue() + 1;
    }
}
