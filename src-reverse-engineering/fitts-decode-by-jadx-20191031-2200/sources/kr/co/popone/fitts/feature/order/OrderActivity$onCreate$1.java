package kr.co.popone.fitts.feature.order;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$1<T, R> implements Function<T, R> {
    public static final OrderActivity$onCreate$1 INSTANCE = new OrderActivity$onCreate$1();

    OrderActivity$onCreate$1() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((CharSequence) obj));
    }

    public final int apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.length();
    }
}
