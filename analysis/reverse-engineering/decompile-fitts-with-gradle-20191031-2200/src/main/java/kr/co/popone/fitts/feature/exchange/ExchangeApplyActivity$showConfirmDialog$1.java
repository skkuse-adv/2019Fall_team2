package kr.co.popone.fitts.feature.exchange;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity.Companion;
import org.jetbrains.annotations.NotNull;

final class ExchangeApplyActivity$showConfirmDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$showConfirmDialog$1(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.getViewModel().requestExchange(new Function1<Pair<? extends Long, ? extends Long>, Unit>(this) {
            final /* synthetic */ ExchangeApplyActivity$showConfirmDialog$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Pair<Long, Long> pair) {
                Intrinsics.checkParameterIsNotNull(pair, "it");
                Companion companion = ExchangeCompleteActivity.Companion;
                ExchangeApplyActivity exchangeApplyActivity = this.this$0.this$0;
                long longValue = ((Number) pair.getFirst()).longValue();
                Object second = pair.getSecond();
                if (second == null) {
                    Intrinsics.throwNpe();
                }
                long longValue2 = ((Number) second).longValue();
                String str = (String) this.this$0.this$0.getViewModel().getPaymentMethod().getValue();
                if (str == null) {
                    str = "";
                }
                companion.startExchangeApplyComplete(exchangeApplyActivity, longValue, longValue2, str);
                this.this$0.this$0.finish();
            }
        });
    }
}
