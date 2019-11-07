package kr.co.popone.fitts.feature.coupon;

import java.util.List;
import kr.co.popone.fitts.feature.coupon.CouponListAdapter.DataSource;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import org.jetbrains.annotations.NotNull;

public final class CouponListFragment$onViewCreated$2 implements DataSource {
    final /* synthetic */ CouponListFragment this$0;

    CouponListFragment$onViewCreated$2(CouponListFragment couponListFragment) {
        this.this$0 = couponListFragment;
    }

    public int getAvailableCouponCount() {
        return this.this$0.availableCouponCount;
    }

    @NotNull
    public List<CouponInfo> getItems() {
        return this.this$0.couponInfoList;
    }
}
