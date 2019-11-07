package kr.co.popone.fitts.model.datamodel.social.feed;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TrendTypeKt {
    public static final boolean isTrendType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return Intrinsics.areEqual((Object) str, (Object) TrendType.TREND.getValue()) || Intrinsics.areEqual((Object) str, (Object) TrendType.POPULAR.getValue());
    }

    @Nullable
    public static final TrendType toTrendType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        if (Intrinsics.areEqual((Object) str, (Object) TrendType.TREND.getValue())) {
            return TrendType.TREND;
        }
        if (Intrinsics.areEqual((Object) str, (Object) TrendType.POPULAR.getValue())) {
            return TrendType.POPULAR;
        }
        return null;
    }
}
