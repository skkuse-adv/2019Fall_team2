package kr.co.popone.fitts.feature.push.order;

import io.reactivex.functions.Predicate;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$8<T> implements Predicate<Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence>> {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$8(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final boolean test(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
