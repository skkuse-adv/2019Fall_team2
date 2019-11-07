package kr.co.popone.fitts.feature.coupon;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class UsedCouponHistoryFragment$onViewCreated$3 implements OnRefreshListener {
    final /* synthetic */ UsedCouponHistoryFragment this$0;

    UsedCouponHistoryFragment$onViewCreated$3(UsedCouponHistoryFragment usedCouponHistoryFragment) {
        this.this$0 = usedCouponHistoryFragment;
    }

    public final void onRefresh() {
        this.this$0.loadUsedCouponHistory(true);
    }
}
