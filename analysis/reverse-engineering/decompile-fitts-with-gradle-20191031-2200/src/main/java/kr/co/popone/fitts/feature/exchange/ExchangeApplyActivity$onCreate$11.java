package kr.co.popone.fitts.feature.exchange;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ExchangeApplyActivity$onCreate$11<T> implements Predicate<CharSequence> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$11(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final boolean test(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
