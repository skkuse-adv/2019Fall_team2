package kr.co.popone.fitts.feature.ncommerce;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;

public final class PointUsageHistoryFragment_MembersInjector implements MembersInjector<PointUsageHistoryFragment> {
    private final Provider<NCommerceViewModel> viewModelProvider;

    public PointUsageHistoryFragment_MembersInjector(Provider<NCommerceViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PointUsageHistoryFragment> create(Provider<NCommerceViewModel> provider) {
        return new PointUsageHistoryFragment_MembersInjector(provider);
    }

    public void injectMembers(PointUsageHistoryFragment pointUsageHistoryFragment) {
        injectViewModel(pointUsageHistoryFragment, (NCommerceViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PointUsageHistoryFragment pointUsageHistoryFragment, NCommerceViewModel nCommerceViewModel) {
        pointUsageHistoryFragment.viewModel = nCommerceViewModel;
    }
}
