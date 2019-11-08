package kr.co.popone.fitts.feature.refund;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$onCreate$12<T, R> implements Function<T, R> {
    public static final RefundApplyActivity$onCreate$12 INSTANCE = new RefundApplyActivity$onCreate$12();

    RefundApplyActivity$onCreate$12() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((CharSequence) obj));
    }

    public final int apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.length();
    }
}
