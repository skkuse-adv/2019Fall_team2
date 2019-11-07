package kr.co.popone.fitts.viewmodel.exchange.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteFragment;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeCompleteFragmentModule {
    @NotNull
    public final ExchangeDetailViewModel provideExchangeDetailViewModel(@NotNull ExchangeCompleteFragment exchangeCompleteFragment, @NotNull ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(exchangeCompleteFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(exchangeDetailViewModelFactory, "viewModelFactory");
        FragmentActivity activity = exchangeCompleteFragment.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        ViewModel viewModel = ViewModelProviders.of(activity, (Factory) exchangeDetailViewModelFactory).get(ExchangeDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ilViewModel::class.java)]");
        return (ExchangeDetailViewModel) viewModel;
    }

    @NotNull
    public final ExchangeDetailViewModelFactory providesViewModelFactory(@NotNull ExchangeRepository exchangeRepository) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository, "exchangeRepository");
        return new ExchangeDetailViewModelFactory(exchangeRepository);
    }
}
