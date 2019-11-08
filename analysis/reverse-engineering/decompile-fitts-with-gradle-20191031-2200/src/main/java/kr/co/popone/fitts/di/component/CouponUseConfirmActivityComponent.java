package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity;

public interface CouponUseConfirmActivityComponent extends AndroidInjector<CouponUseConfirmActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponUseConfirmActivity> {
    }
}
