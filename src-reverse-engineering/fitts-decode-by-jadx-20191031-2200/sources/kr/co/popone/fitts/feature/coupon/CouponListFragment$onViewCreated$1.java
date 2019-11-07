package kr.co.popone.fitts.feature.coupon;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class CouponListFragment$onViewCreated$1 implements OnRefreshListener {
    final /* synthetic */ CouponListFragment this$0;

    CouponListFragment$onViewCreated$1(CouponListFragment couponListFragment) {
        this.this$0 = couponListFragment;
    }

    public final void onRefresh() {
        this.this$0.loadAvailableCouponCount();
        this.this$0.loadCouponList(false);
    }
}
