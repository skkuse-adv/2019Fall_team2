package kr.co.popone.fitts.feature.exchange;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ExchangeApplyActivity$onCreate$15<T, R> implements Function<T, R> {
    public static final ExchangeApplyActivity$onCreate$15 INSTANCE = new ExchangeApplyActivity$onCreate$15();

    ExchangeApplyActivity$onCreate$15() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((CharSequence) obj));
    }

    public final int apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.length();
    }
}
