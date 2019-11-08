package kr.co.popone.fitts.feature.exchange;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class ExchangeApplyActivity$onCreate$27<T> implements Observer<Integer> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$27(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        textView.setText(String.valueOf(num.intValue()));
    }
}
