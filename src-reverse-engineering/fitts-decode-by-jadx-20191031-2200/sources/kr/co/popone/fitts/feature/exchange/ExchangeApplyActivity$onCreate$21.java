package kr.co.popone.fitts.feature.exchange;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ExchangeApplyActivity$onCreate$21<T, R> implements Function<T, R> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$21(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Integer) obj));
    }

    public final boolean apply(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return this.this$0.isRadioButtonChecked();
    }
}
