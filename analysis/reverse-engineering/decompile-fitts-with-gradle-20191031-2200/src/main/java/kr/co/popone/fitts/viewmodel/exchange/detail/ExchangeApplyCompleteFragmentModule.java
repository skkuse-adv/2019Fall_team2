package kr.co.popone.fitts.viewmodel.exchange.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeApplyCompleteFragmentModule {
    @NotNull
    public final ExchangeDetailViewModel provideExchangeDetailViewModel(@NotNull ExchangeCompleteActivity exchangeCompleteActivity, @NotNull ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(exchangeCompleteActivity, "activity");
        Intrinsics.checkParameterIsNotNull(exchangeDetailViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) exchangeCompleteActivity, (Factory) exchangeDetailViewModelFactory).get(ExchangeDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ilViewModel::class.java)]");
        return (ExchangeDetailViewModel) viewModel;
    }

    @NotNull
    public final ExchangeDetailViewModelFactory providesViewModelFactory(@NotNull ExchangeRepository exchangeRepository) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository, "exchangeRepository");
        return new ExchangeDetailViewModelFactory(exchangeRepository);
    }
}
