package kr.co.popone.fitts.feature.card;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.coupon.CouponAPI;

public final class FittsCardRendingActivity_MembersInjector implements MembersInjector<FittsCardRendingActivity> {
    private final Provider<CouponAPI> couponAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;

    public FittsCardRendingActivity_MembersInjector(Provider<CouponAPI> provider, Provider<EventTracker> provider2) {
        this.couponAPIProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public static MembersInjector<FittsCardRendingActivity> create(Provider<CouponAPI> provider, Provider<EventTracker> provider2) {
        return new FittsCardRendingActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(FittsCardRendingActivity fittsCardRendingActivity) {
        injectCouponAPI(fittsCardRendingActivity, (CouponAPI) this.couponAPIProvider.get());
        injectEventTracker(fittsCardRendingActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectCouponAPI(FittsCardRendingActivity fittsCardRendingActivity, CouponAPI couponAPI) {
        fittsCardRendingActivity.couponAPI = couponAPI;
    }

    public static void injectEventTracker(FittsCardRendingActivity fittsCardRendingActivity, EventTracker eventTracker) {
        fittsCardRendingActivity.eventTracker = eventTracker;
    }
}
