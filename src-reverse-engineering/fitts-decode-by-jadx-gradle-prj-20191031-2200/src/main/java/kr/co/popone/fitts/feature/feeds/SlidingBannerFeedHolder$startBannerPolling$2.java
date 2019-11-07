package kr.co.popone.fitts.feature.feeds;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class SlidingBannerFeedHolder$startBannerPolling$2<T> implements Predicate<Integer> {
    public static final SlidingBannerFeedHolder$startBannerPolling$2 INSTANCE = new SlidingBannerFeedHolder$startBannerPolling$2();

    SlidingBannerFeedHolder$startBannerPolling$2() {
    }

    public final boolean test(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return num.intValue() != -1;
    }
}
