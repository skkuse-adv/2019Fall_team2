package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class CouponUseActivity_MembersInjector implements MembersInjector<CouponUseActivity> {
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<UserAPI> userAPIProvider;

    public CouponUseActivity_MembersInjector(Provider<UserAPI> provider, Provider<PostAPI> provider2) {
        this.userAPIProvider = provider;
        this.postAPIProvider = provider2;
    }

    public static MembersInjector<CouponUseActivity> create(Provider<UserAPI> provider, Provider<PostAPI> provider2) {
        return new CouponUseActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(CouponUseActivity couponUseActivity) {
        injectUserAPI(couponUseActivity, (UserAPI) this.userAPIProvider.get());
        injectPostAPI(couponUseActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectUserAPI(CouponUseActivity couponUseActivity, UserAPI userAPI) {
        couponUseActivity.userAPI = userAPI;
    }

    public static void injectPostAPI(CouponUseActivity couponUseActivity, PostAPI postAPI) {
        couponUseActivity.postAPI = postAPI;
    }
}
