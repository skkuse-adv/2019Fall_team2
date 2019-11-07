package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.coupon.UsedCouponHistoryFragment;

public interface UsedCouponHistoryFragmentComponent extends AndroidInjector<UsedCouponHistoryFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<UsedCouponHistoryFragment> {
    }
}
