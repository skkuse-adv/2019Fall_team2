package kr.co.popone.fitts.feature.ncommerce;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;

public final class PointHistoryFragment_MembersInjector implements MembersInjector<PointHistoryFragment> {
    private final Provider<NCommerceViewModel> viewModelProvider;

    public PointHistoryFragment_MembersInjector(Provider<NCommerceViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PointHistoryFragment> create(Provider<NCommerceViewModel> provider) {
        return new PointHistoryFragment_MembersInjector(provider);
    }

    public void injectMembers(PointHistoryFragment pointHistoryFragment) {
        injectViewModel(pointHistoryFragment, (NCommerceViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PointHistoryFragment pointHistoryFragment, NCommerceViewModel nCommerceViewModel) {
        pointHistoryFragment.viewModel = nCommerceViewModel;
    }
}
