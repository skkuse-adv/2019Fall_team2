package kr.co.popone.fitts.feature.push.order;

import io.reactivex.functions.Predicate;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$1<T> implements Predicate<Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence>> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$1(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final boolean test(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
