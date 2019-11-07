package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.remote.refund.PreRefundResponse;
import org.jetbrains.annotations.NotNull;

final class RefundRepository$requestPreRefundInfo$1<T, R> implements Function<T, R> {
    final /* synthetic */ RefundRepository this$0;

    RefundRepository$requestPreRefundInfo$1(RefundRepository refundRepository) {
        this.this$0 = refundRepository;
    }

    @NotNull
    public final ExchangeRefundVariant apply(@NotNull PreRefundResponse preRefundResponse) {
        Intrinsics.checkParameterIsNotNull(preRefundResponse, "it");
        return this.this$0.mapToDomain(preRefundResponse);
    }
}
