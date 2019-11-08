package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;
import org.jetbrains.annotations.NotNull;

final class ExchangeRepository$requestExchangeApply$1<T, R> implements Function<T, R> {
    final /* synthetic */ long $variantId;

    ExchangeRepository$requestExchangeApply$1(long j) {
        this.$variantId = j;
    }

    @NotNull
    public final Pair<Long, Long> apply(@NotNull ExchangeApplyResponse exchangeApplyResponse) {
        Intrinsics.checkParameterIsNotNull(exchangeApplyResponse, "it");
        return new Pair<>(Long.valueOf(this.$variantId), exchangeApplyResponse.getOrderLineItemVariant().getExchangeId());
    }
}
