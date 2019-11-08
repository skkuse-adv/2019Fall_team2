package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.coupon.CouponAPI;

public final class TermsAgreeWebViewActivity_MembersInjector implements MembersInjector<TermsAgreeWebViewActivity> {
    private final Provider<CouponAPI> couponAPIProvider;

    public TermsAgreeWebViewActivity_MembersInjector(Provider<CouponAPI> provider) {
        this.couponAPIProvider = provider;
    }

    public static MembersInjector<TermsAgreeWebViewActivity> create(Provider<CouponAPI> provider) {
        return new TermsAgreeWebViewActivity_MembersInjector(provider);
    }

    public void injectMembers(TermsAgreeWebViewActivity termsAgreeWebViewActivity) {
        injectCouponAPI(termsAgreeWebViewActivity, (CouponAPI) this.couponAPIProvider.get());
    }

    public static void injectCouponAPI(TermsAgreeWebViewActivity termsAgreeWebViewActivity, CouponAPI couponAPI) {
        termsAgreeWebViewActivity.couponAPI = couponAPI;
    }
}
