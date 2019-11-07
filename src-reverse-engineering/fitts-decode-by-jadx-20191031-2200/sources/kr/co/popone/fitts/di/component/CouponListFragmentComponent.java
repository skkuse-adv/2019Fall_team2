package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.CouponListFragment;

public interface CouponListFragmentComponent extends AndroidInjector<CouponListFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CouponListFragment> {
    }
}
