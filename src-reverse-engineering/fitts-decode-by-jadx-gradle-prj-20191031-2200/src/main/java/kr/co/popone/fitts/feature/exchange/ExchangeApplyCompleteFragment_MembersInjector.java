package kr.co.popone.fitts.feature.exchange;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModel;

public final class ExchangeApplyCompleteFragment_MembersInjector implements MembersInjector<ExchangeApplyCompleteFragment> {
    private final Provider<ExchangeDetailViewModel> viewModelProvider;

    public ExchangeApplyCompleteFragment_MembersInjector(Provider<ExchangeDetailViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ExchangeApplyCompleteFragment> create(Provider<ExchangeDetailViewModel> provider) {
        return new ExchangeApplyCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        injectViewModel(exchangeApplyCompleteFragment, (ExchangeDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment, ExchangeDetailViewModel exchangeDetailViewModel) {
        exchangeApplyCompleteFragment.viewModel = exchangeDetailViewModel;
    }
}
