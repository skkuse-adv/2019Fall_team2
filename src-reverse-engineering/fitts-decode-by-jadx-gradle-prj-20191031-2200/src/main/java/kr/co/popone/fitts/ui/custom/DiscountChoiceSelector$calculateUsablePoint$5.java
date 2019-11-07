package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class DiscountChoiceSelector$calculateUsablePoint$5<T, R> implements Function<T, R> {
    public static final DiscountChoiceSelector$calculateUsablePoint$5 INSTANCE = new DiscountChoiceSelector$calculateUsablePoint$5();

    DiscountChoiceSelector$calculateUsablePoint$5() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((Double) obj));
    }

    public final int apply(@NotNull Double d) {
        Intrinsics.checkParameterIsNotNull(d, "it");
        return (int) d.doubleValue();
    }
}
