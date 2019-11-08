package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponHomeActivity;

public interface CouponHomeActivityComponent extends AndroidInjector<CouponHomeActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponHomeActivity> {
    }
}
