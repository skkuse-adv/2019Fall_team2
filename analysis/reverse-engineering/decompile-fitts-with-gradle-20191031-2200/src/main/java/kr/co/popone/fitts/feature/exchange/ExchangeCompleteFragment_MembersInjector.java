package kr.co.popone.fitts.feature.exchange;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModel;

public final class ExchangeCompleteFragment_MembersInjector implements MembersInjector<ExchangeCompleteFragment> {
    private final Provider<ExchangeDetailViewModel> viewModelProvider;

    public ExchangeCompleteFragment_MembersInjector(Provider<ExchangeDetailViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ExchangeCompleteFragment> create(Provider<ExchangeDetailViewModel> provider) {
        return new ExchangeCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(ExchangeCompleteFragment exchangeCompleteFragment) {
        injectViewModel(exchangeCompleteFragment, (ExchangeDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ExchangeCompleteFragment exchangeCompleteFragment, ExchangeDetailViewModel exchangeDetailViewModel) {
        exchangeCompleteFragment.viewModel = exchangeDetailViewModel;
    }
}
