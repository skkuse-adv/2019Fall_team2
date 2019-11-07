package kr.co.popone.fitts.feature.trend;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel;

public final class TrendFeedActivity_MembersInjector implements MembersInjector<TrendFeedActivity> {
    private final Provider<TrendFeedViewModel> vmProvider;

    public TrendFeedActivity_MembersInjector(Provider<TrendFeedViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<TrendFeedActivity> create(Provider<TrendFeedViewModel> provider) {
        return new TrendFeedActivity_MembersInjector(provider);
    }

    public void injectMembers(TrendFeedActivity trendFeedActivity) {
        injectVm(trendFeedActivity, (TrendFeedViewModel) this.vmProvider.get());
    }

    public static void injectVm(TrendFeedActivity trendFeedActivity, TrendFeedViewModel trendFeedViewModel) {
        trendFeedActivity.vm = trendFeedViewModel;
    }
}
