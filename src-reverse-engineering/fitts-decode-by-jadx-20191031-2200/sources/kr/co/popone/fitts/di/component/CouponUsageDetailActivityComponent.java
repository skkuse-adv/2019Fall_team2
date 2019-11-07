package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity;

public interface CouponUsageDetailActivityComponent extends AndroidInjector<CouponUsageDetailActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponUsageDetailActivity> {
    }
}
