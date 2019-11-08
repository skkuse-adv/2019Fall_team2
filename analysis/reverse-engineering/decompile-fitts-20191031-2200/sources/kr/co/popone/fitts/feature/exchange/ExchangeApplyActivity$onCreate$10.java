package kr.co.popone.fitts.feature.exchange;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector.ExchangeReason;
import org.jetbrains.annotations.Nullable;

final class ExchangeApplyActivity$onCreate$10<T> implements Observer<ExchangeReason> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$10(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(@Nullable ExchangeReason exchangeReason) {
        String str = "textExchangeReason";
        if (exchangeReason == null) {
            ExchangeApplyActivity exchangeApplyActivity = this.this$0;
            TextView textView = (TextView) exchangeApplyActivity._$_findCachedViewById(C0010R$id.textExchangeReason);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            exchangeApplyActivity.updateTextViewColor(textView, C0006R$color.neon_red);
            return;
        }
        ExchangeApplyActivity exchangeApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) exchangeApplyActivity2._$_findCachedViewById(C0010R$id.textExchangeReason);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        exchangeApplyActivity2.updateTextViewColor(textView2, C0006R$color.gray6);
    }
}
