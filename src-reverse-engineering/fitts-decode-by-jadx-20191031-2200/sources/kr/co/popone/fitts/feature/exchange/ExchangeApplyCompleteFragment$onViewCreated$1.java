package kr.co.popone.fitts.feature.exchange;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.DimensionsKt;

final class ExchangeApplyCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$1(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onClick(View view) {
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        DialogExtensions.showConfirmDialog$default(dialogExtensions, context, "교환 신청을 취소하시겠어요?", "이미 상품을 발송하신 경우\n교환 신청 취소가 불가능합니다.", new Function0<Unit>(this) {
            final /* synthetic */ ExchangeApplyCompleteFragment$onViewCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.getViewModel().cancelExchange();
            }
        }, null, null, null, 0, DimensionsKt.HDPI, null);
    }
}
