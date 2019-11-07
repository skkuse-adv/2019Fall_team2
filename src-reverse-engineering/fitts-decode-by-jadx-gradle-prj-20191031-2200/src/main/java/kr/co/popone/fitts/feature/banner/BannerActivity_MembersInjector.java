package kr.co.popone.fitts.feature.banner;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.banner.BannerViewModel;

public final class BannerActivity_MembersInjector implements MembersInjector<BannerActivity> {
    private final Provider<BannerViewModel> viewModelProvider;

    public BannerActivity_MembersInjector(Provider<BannerViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<BannerActivity> create(Provider<BannerViewModel> provider) {
        return new BannerActivity_MembersInjector(provider);
    }

    public void injectMembers(BannerActivity bannerActivity) {
        injectViewModel(bannerActivity, (BannerViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(BannerActivity bannerActivity, BannerViewModel bannerViewModel) {
        bannerActivity.viewModel = bannerViewModel;
    }
}
