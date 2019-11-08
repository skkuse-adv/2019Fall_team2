package kr.co.popone.fitts.feature.push.order;

import io.reactivex.functions.Predicate;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$8<T> implements Predicate<Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence>> {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$8(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final boolean test(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
