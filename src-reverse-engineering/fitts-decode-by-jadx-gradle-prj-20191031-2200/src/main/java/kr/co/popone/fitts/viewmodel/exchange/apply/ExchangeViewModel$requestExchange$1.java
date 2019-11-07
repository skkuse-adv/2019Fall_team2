package kr.co.popone.fitts.viewmodel.exchange.apply;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class ExchangeViewModel$requestExchange$1<T> implements Consumer<Pair<? extends Long, ? extends Long>> {
    final /* synthetic */ Function1 $body;

    ExchangeViewModel$requestExchange$1(Function1 function1) {
        this.$body = function1;
    }

    public final void accept(Pair<Long, Long> pair) {
        Function1 function1 = this.$body;
        Intrinsics.checkExpressionValueIsNotNull(pair, "it");
        function1.invoke(pair);
    }
}
