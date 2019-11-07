package kr.co.popone.fitts.feature.coupon;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class CouponUseActivity$onCreate$13<T1, T2, R> implements BiFunction<Integer, Integer, Integer> {
    public static final CouponUseActivity$onCreate$13 INSTANCE = new CouponUseActivity$onCreate$13();

    CouponUseActivity$onCreate$13() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        return Integer.valueOf(apply((Integer) obj, (Integer) obj2));
    }

    public final int apply(@NotNull Integer num, @NotNull Integer num2) {
        Intrinsics.checkParameterIsNotNull(num, "t1");
        Intrinsics.checkParameterIsNotNull(num2, "t2");
        return num.intValue() + num2.intValue();
    }
}
