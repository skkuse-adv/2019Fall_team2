package kr.co.popone.fitts.feature.push.order;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class OrderPartCancelFragment$onViewCreated$8<T> implements Observer<ExchangeRefundVariant> {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$onViewCreated$8(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final void onChanged(ExchangeRefundVariant exchangeRefundVariant) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textOption);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textOption");
        if (exchangeRefundVariant == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(exchangeRefundVariant.getProductInfoSummary());
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textDetailOption);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textDetailOption");
        textView2.setText(exchangeRefundVariant.getProductOptionInfoSummary());
    }
}
