package kr.co.popone.fitts.feature.coupon;

import kr.co.popone.fitts.feature.coupon.CouponListAdapter.Delegate;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;

public final class CouponListFragment$onViewCreated$3 implements Delegate {
    final /* synthetic */ CouponListFragment this$0;

    CouponListFragment$onViewCreated$3(CouponListFragment couponListFragment) {
        this.this$0 = couponListFragment;
    }

    public void termsButtonClicked(int i) {
        CouponListFragment couponListFragment = this.this$0;
        couponListFragment.startTermsAgreeWebViewActivity(103, (CouponInfo) couponListFragment.couponInfoList.get(i));
    }

    public void useButtonClicked(int i) {
        CouponListFragment couponListFragment = this.this$0;
        couponListFragment.useFittsCoupon((CouponInfo) couponListFragment.couponInfoList.get(i));
    }
}
