package kr.co.popone.fitts.feature.exchange;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel;

public final class ExchangeApplyActivity_MembersInjector implements MembersInjector<ExchangeApplyActivity> {
    private final Provider<ExchangeViewModel> viewModelProvider;

    public ExchangeApplyActivity_MembersInjector(Provider<ExchangeViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ExchangeApplyActivity> create(Provider<ExchangeViewModel> provider) {
        return new ExchangeApplyActivity_MembersInjector(provider);
    }

    public void injectMembers(ExchangeApplyActivity exchangeApplyActivity) {
        injectViewModel(exchangeApplyActivity, (ExchangeViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ExchangeApplyActivity exchangeApplyActivity, ExchangeViewModel exchangeViewModel) {
        exchangeApplyActivity.viewModel = exchangeViewModel;
    }
}
