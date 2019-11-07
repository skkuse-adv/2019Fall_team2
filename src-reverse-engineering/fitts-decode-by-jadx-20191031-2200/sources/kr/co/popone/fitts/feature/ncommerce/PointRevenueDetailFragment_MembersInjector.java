package kr.co.popone.fitts.feature.ncommerce;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;

public final class PointRevenueDetailFragment_MembersInjector implements MembersInjector<PointRevenueDetailFragment> {
    private final Provider<NCommerceViewModel> viewModelProvider;

    public PointRevenueDetailFragment_MembersInjector(Provider<NCommerceViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PointRevenueDetailFragment> create(Provider<NCommerceViewModel> provider) {
        return new PointRevenueDetailFragment_MembersInjector(provider);
    }

    public void injectMembers(PointRevenueDetailFragment pointRevenueDetailFragment) {
        injectViewModel(pointRevenueDetailFragment, (NCommerceViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PointRevenueDetailFragment pointRevenueDetailFragment, NCommerceViewModel nCommerceViewModel) {
        pointRevenueDetailFragment.viewModel = nCommerceViewModel;
    }
}
