package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponUseActivity;

public interface CouponUseActivityComponent extends AndroidInjector<CouponUseActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponUseActivity> {
    }
}
