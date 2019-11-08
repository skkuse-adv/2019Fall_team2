package kr.co.popone.fitts.feature.refund;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$onCreate$17<T> implements Predicate<Integer> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$17(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final boolean test(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
