package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.coupon.CouponAPI;

public final class CouponRegisterActivity_MembersInjector implements MembersInjector<CouponRegisterActivity> {
    private final Provider<CouponAPI> couponAPIProvider;

    public CouponRegisterActivity_MembersInjector(Provider<CouponAPI> provider) {
        this.couponAPIProvider = provider;
    }

    public static MembersInjector<CouponRegisterActivity> create(Provider<CouponAPI> provider) {
        return new CouponRegisterActivity_MembersInjector(provider);
    }

    public void injectMembers(CouponRegisterActivity couponRegisterActivity) {
        injectCouponAPI(couponRegisterActivity, (CouponAPI) this.couponAPIProvider.get());
    }

    public static void injectCouponAPI(CouponRegisterActivity couponRegisterActivity, CouponAPI couponAPI) {
        couponRegisterActivity.couponAPI = couponAPI;
    }
}
