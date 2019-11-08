package kr.co.popone.fitts.viewmodel.exchange.apply;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyActivity;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeModule {
    @NotNull
    public final ExchangeViewModel provideRefundViewModel(@NotNull ExchangeApplyActivity exchangeApplyActivity, @NotNull ExchangeViewModelFactory exchangeViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(exchangeApplyActivity, "activity");
        Intrinsics.checkParameterIsNotNull(exchangeViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) exchangeApplyActivity, (Factory) exchangeViewModelFactory).get(ExchangeViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…geViewModel::class.java)]");
        return (ExchangeViewModel) viewModel;
    }

    @NotNull
    public final ExchangeViewModelFactory providesViewModelFactory(@NotNull ExchangeRepository exchangeRepository) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository, "exchangeRepository");
        return new ExchangeViewModelFactory(exchangeRepository);
    }
}
