package kr.co.popone.fitts.feature.coupon;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CouponRegisterActivity$onCreate$2<T> implements Consumer<CharSequence> {
    final /* synthetic */ CouponRegisterActivity this$0;

    CouponRegisterActivity$onCreate$2(CouponRegisterActivity couponRegisterActivity) {
        this.this$0 = couponRegisterActivity;
    }

    public final void accept(CharSequence charSequence) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "errorMessageTextView");
        textView.setText("");
    }
}
