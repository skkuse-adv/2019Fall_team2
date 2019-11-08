package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponRegisterActivity;

public interface CouponRegisterActivityComponent extends AndroidInjector<CouponRegisterActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponRegisterActivity> {
    }
}
