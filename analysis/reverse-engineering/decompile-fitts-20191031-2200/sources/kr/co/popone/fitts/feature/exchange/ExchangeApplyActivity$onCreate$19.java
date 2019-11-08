package kr.co.popone.fitts.feature.exchange;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class ExchangeApplyActivity$onCreate$19<T> implements Consumer<Boolean> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$19(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        String str = "textBankInfo";
        if (bool.booleanValue()) {
            ExchangeApplyActivity exchangeApplyActivity = this.this$0;
            TextView textView = (TextView) exchangeApplyActivity._$_findCachedViewById(C0010R$id.textBankInfo);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            exchangeApplyActivity.updateTextViewColor(textView, C0006R$color.gray6);
            return;
        }
        ExchangeApplyActivity exchangeApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) exchangeApplyActivity2._$_findCachedViewById(C0010R$id.textBankInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        exchangeApplyActivity2.updateTextViewColor(textView2, C0006R$color.neon_red);
    }
}
