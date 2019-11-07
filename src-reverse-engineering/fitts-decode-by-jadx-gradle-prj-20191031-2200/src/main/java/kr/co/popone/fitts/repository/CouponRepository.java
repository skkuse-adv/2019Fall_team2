package kr.co.popone.fitts.repository;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import org.jetbrains.annotations.NotNull;

public final class CouponRepository {
    public CouponRepository(@NotNull CouponAPI couponAPI) {
        Intrinsics.checkParameterIsNotNull(couponAPI, "couponAPI");
    }
}
