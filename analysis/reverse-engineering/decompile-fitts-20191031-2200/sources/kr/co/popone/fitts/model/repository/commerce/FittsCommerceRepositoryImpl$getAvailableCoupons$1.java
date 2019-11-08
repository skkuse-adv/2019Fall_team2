package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import org.jetbrains.annotations.NotNull;

final class FittsCommerceRepositoryImpl$getAvailableCoupons$1<T, R> implements Function<T, R> {
    final /* synthetic */ int $totalPrice;

    FittsCommerceRepositoryImpl$getAvailableCoupons$1(int i) {
        this.$totalPrice = i;
    }

    @NotNull
    public final List<CouponInfo> apply(@NotNull List<CouponInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "coupon");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            CouponInfo couponInfo = (CouponInfo) next;
            int i = this.$totalPrice;
            Integer minOrderPrice = couponInfo.getMinOrderPrice();
            boolean z = false;
            if (i >= (minOrderPrice != null ? minOrderPrice.intValue() : 0)) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
