package kr.co.popone.fitts.feature.refund;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity.Companion;
import org.jetbrains.annotations.NotNull;

final class RefundApplyActivity$showConfirmDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$showConfirmDialog$1(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.getViewModel().requestRefund(new Function1<Pair<? extends Long, ? extends Long>, Unit>(this) {
            final /* synthetic */ RefundApplyActivity$showConfirmDialog$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Pair<Long, Long> pair) {
                Intrinsics.checkParameterIsNotNull(pair, "it");
                Companion companion = RefundCompleteActivity.Companion;
                RefundApplyActivity refundApplyActivity = this.this$0.this$0;
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
                companion.startRefundApplyComplete(refundApplyActivity, longValue, longValue2, str);
                this.this$0.this$0.finish();
            }
        });
    }
}
