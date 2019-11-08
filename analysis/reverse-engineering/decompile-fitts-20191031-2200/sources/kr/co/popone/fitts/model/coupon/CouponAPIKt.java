package kr.co.popone.fitts.model.coupon;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import org.jetbrains.annotations.NotNull;

public final class CouponAPIKt {
    @NotNull
    public static final String[] mapToCouponNameAndValueArray(@NotNull List<CouponInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        arrayList.add("쿠폰을 선택하세요");
        for (CouponInfo couponInfo : list) {
            if (!couponInfo.getExpired()) {
                arrayList.add(couponInfo.getDisplayMessage());
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
