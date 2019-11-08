package kr.co.popone.fitts.feature.recommend.fittie;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.recommend.fittie.FittieRecommendViewModel;

public final class FittieRecommendActivity_MembersInjector implements MembersInjector<FittieRecommendActivity> {
    private final Provider<FittieRecommendViewModel> vmProvider;

    public FittieRecommendActivity_MembersInjector(Provider<FittieRecommendViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<FittieRecommendActivity> create(Provider<FittieRecommendViewModel> provider) {
        return new FittieRecommendActivity_MembersInjector(provider);
    }

    public void injectMembers(FittieRecommendActivity fittieRecommendActivity) {
        injectVm(fittieRecommendActivity, (FittieRecommendViewModel) this.vmProvider.get());
    }

    public static void injectVm(FittieRecommendActivity fittieRecommendActivity, FittieRecommendViewModel fittieRecommendViewModel) {
        fittieRecommendActivity.vm = fittieRecommendViewModel;
    }
}
