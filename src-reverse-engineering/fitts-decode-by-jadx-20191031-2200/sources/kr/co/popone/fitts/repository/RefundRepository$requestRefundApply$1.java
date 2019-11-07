package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;
import org.jetbrains.annotations.NotNull;

final class RefundRepository$requestRefundApply$1<T, R> implements Function<T, R> {
    final /* synthetic */ long $variantId;

    RefundRepository$requestRefundApply$1(long j) {
        this.$variantId = j;
    }

    @NotNull
    public final Pair<Long, Long> apply(@NotNull RefundApplyResponse refundApplyResponse) {
        Intrinsics.checkParameterIsNotNull(refundApplyResponse, "it");
        return new Pair<>(Long.valueOf(this.$variantId), refundApplyResponse.getOrderLineItemVariant().getRefundId());
    }
}
