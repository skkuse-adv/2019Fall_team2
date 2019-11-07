package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class DiscountChoiceSelector$calculateUsablePoint$1<T> implements Predicate<String> {
    public static final DiscountChoiceSelector$calculateUsablePoint$1 INSTANCE = new DiscountChoiceSelector$calculateUsablePoint$1();

    DiscountChoiceSelector$calculateUsablePoint$1() {
    }

    public final boolean test(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return !StringsKt__StringsJVMKt.isBlank(str);
    }
}
