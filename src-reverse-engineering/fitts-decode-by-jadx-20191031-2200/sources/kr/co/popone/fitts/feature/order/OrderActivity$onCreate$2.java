package kr.co.popone.fitts.feature.order;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class OrderActivity$onCreate$2<T> implements Consumer<Integer> {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$2(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void accept(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoWordCountTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "shippingMemoWordCountTextView");
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.append("/50");
        textView.setText(sb.toString());
    }
}
