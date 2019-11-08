package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class StoreOptionSelectDialog$initializeView$5<T, R> implements Function<T, R> {
    public static final StoreOptionSelectDialog$initializeView$5 INSTANCE = new StoreOptionSelectDialog$initializeView$5();

    StoreOptionSelectDialog$initializeView$5() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Integer) obj));
    }

    public final boolean apply(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return num.intValue() == 0;
    }
}
