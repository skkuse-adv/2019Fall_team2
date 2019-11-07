package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class DiscountChoiceSelector$calculateUsablePoint$2<T, R> implements Function<T, R> {
    public static final DiscountChoiceSelector$calculateUsablePoint$2 INSTANCE = new DiscountChoiceSelector$calculateUsablePoint$2();

    DiscountChoiceSelector$calculateUsablePoint$2() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Double.valueOf(apply((String) obj));
    }

    public final double apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return Double.parseDouble(str);
    }
}
