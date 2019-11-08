package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.remote.exchange.PreExchageResponse;
import org.jetbrains.annotations.NotNull;

final class ExchangeRepository$requestPreExchangeInfo$1<T, R> implements Function<T, R> {
    final /* synthetic */ ExchangeRepository this$0;

    ExchangeRepository$requestPreExchangeInfo$1(ExchangeRepository exchangeRepository) {
        this.this$0 = exchangeRepository;
    }

    @NotNull
    public final ExchangeRefundVariant apply(@NotNull PreExchageResponse preExchageResponse) {
        Intrinsics.checkParameterIsNotNull(preExchageResponse, "it");
        return this.this$0.mapToDomain(preExchageResponse);
    }
}
