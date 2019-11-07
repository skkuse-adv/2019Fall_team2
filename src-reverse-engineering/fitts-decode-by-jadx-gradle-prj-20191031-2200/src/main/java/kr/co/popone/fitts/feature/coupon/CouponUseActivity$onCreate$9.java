package kr.co.popone.fitts.feature.coupon;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;

final class CouponUseActivity$onCreate$9<T> implements Consumer<CharSequence> {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$9(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void accept(CharSequence charSequence) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoWordCountTextView);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence.length());
        sb.append("/50");
        textView.setText(sb.toString());
    }
}
