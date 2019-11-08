package kr.co.popone.fitts.feature.refund;

import io.reactivex.functions.Predicate;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$onCreate$14<T> implements Predicate<Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence>> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$14(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final boolean test(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
