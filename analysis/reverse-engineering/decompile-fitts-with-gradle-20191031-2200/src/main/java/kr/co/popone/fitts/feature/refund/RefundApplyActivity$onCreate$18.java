package kr.co.popone.fitts.feature.refund;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$onCreate$18<T, R> implements Function<T, R> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$18(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Integer) obj));
    }

    public final boolean apply(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return this.this$0.isRadioButtonChecked();
    }
}
