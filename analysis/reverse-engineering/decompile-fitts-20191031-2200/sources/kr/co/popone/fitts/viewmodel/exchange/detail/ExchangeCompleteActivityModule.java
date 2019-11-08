package kr.co.popone.fitts.viewmodel.exchange.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyCompleteFragment;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeCompleteActivityModule {
    @NotNull
    public final ExchangeDetailViewModel provideExchangeDetailViewModel(@NotNull ExchangeApplyCompleteFragment exchangeApplyCompleteFragment, @NotNull ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(exchangeApplyCompleteFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(exchangeDetailViewModelFactory, "viewModelFactory");
        FragmentActivity activity = exchangeApplyCompleteFragment.getActivity();
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
