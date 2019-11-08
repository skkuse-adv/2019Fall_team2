package kr.co.popone.fitts.feature.exchange;

import io.reactivex.functions.Predicate;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ExchangeApplyActivity$onCreate$17<T> implements Predicate<Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence>> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$17(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final boolean test(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        return ((Boolean) this.this$0.getViewModel().isVaidationCheckMode().invoke()).booleanValue();
    }
}
