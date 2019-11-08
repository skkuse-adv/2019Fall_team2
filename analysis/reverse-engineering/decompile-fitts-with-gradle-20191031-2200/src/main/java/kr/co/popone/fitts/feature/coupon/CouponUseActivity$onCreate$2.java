package kr.co.popone.fitts.feature.coupon;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class CouponUseActivity$onCreate$2<T, R> implements Function<T, R> {
    public static final CouponUseActivity$onCreate$2 INSTANCE = new CouponUseActivity$onCreate$2();

    CouponUseActivity$onCreate$2() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((CharSequence) obj));
    }

    public final boolean apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }
}
