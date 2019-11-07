package kr.co.popone.fitts.feature.exchange;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModel;

public final class ExchangeCompleteActivity_MembersInjector implements MembersInjector<ExchangeCompleteActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<ExchangeDetailViewModel> viewModelProvider;

    public ExchangeCompleteActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ExchangeDetailViewModel> provider2) {
        this.fragmentInjectorProvider = provider;
        this.viewModelProvider = provider2;
    }

    public static MembersInjector<ExchangeCompleteActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ExchangeDetailViewModel> provider2) {
        return new ExchangeCompleteActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ExchangeCompleteActivity exchangeCompleteActivity) {
        injectFragmentInjector(exchangeCompleteActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectViewModel(exchangeCompleteActivity, (ExchangeDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectFragmentInjector(ExchangeCompleteActivity exchangeCompleteActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        exchangeCompleteActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectViewModel(ExchangeCompleteActivity exchangeCompleteActivity, ExchangeDetailViewModel exchangeDetailViewModel) {
        exchangeCompleteActivity.viewModel = exchangeDetailViewModel;
    }
}
