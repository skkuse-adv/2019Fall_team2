package kr.co.popone.fitts.feature.refund;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$onCreate$11<T> implements Predicate<CharSequence> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$11(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final boolean test(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
