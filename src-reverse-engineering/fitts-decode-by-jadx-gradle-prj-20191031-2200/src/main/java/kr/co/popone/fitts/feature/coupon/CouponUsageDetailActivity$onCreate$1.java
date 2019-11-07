package kr.co.popone.fitts.feature.coupon;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class CouponUsageDetailActivity$onCreate$1 implements OnRefreshListener {
    final /* synthetic */ CouponUsageDetailActivity this$0;

    CouponUsageDetailActivity$onCreate$1(CouponUsageDetailActivity couponUsageDetailActivity) {
        this.this$0 = couponUsageDetailActivity;
    }

    public final void onRefresh() {
        this.this$0.loadCouponUsage();
    }
}
