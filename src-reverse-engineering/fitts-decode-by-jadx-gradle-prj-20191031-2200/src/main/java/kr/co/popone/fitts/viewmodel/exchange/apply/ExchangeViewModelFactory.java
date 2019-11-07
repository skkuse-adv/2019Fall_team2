package kr.co.popone.fitts.viewmodel.exchange.apply;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.repository.ExchangeRepository;
import org.jetbrains.annotations.NotNull;

public final class ExchangeViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final ExchangeRepository exchangeRepository;

    public ExchangeViewModelFactory(@NotNull ExchangeRepository exchangeRepository2) {
        Intrinsics.checkParameterIsNotNull(exchangeRepository2, "exchangeRepository");
        this.exchangeRepository = exchangeRepository2;
    }

    @NotNull
    public final ExchangeRepository getExchangeRepository() {
        return this.exchangeRepository;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new ExchangeViewModel(this.exchangeRepository);
    }
}
