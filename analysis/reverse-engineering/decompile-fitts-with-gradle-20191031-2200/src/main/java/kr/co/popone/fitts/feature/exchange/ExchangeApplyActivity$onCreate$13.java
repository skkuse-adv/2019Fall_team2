package kr.co.popone.fitts.feature.exchange;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class ExchangeApplyActivity$onCreate$13<T> implements Consumer<Integer> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$13(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void accept(Integer num) {
        String str = "textExchangeOption";
        if (Intrinsics.compare(num.intValue(), 1) < 0) {
            ExchangeApplyActivity exchangeApplyActivity = this.this$0;
            TextView textView = (TextView) exchangeApplyActivity._$_findCachedViewById(C0010R$id.textExchangeOption);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            exchangeApplyActivity.updateTextViewColor(textView, C0006R$color.neon_red);
            return;
        }
        ExchangeApplyActivity exchangeApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) exchangeApplyActivity2._$_findCachedViewById(C0010R$id.textExchangeOption);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        exchangeApplyActivity2.updateTextViewColor(textView2, C0006R$color.gray6);
    }
}
