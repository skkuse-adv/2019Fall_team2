package kr.co.popone.fitts.feature.coupon;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.anko.Sdk27PropertiesKt;

final class CouponUseActivity$onCreate$14<T> implements Consumer<Integer> {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$14(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void accept(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.totalPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "totalPriceTextView");
        Intrinsics.checkExpressionValueIsNotNull(num, "total");
        textView.setText(String.valueOf(IntExtensionsKt.commaString(num.intValue())));
        int access$getCouponPoints$p = this.this$0.couponPoints - num.intValue();
        String str = "priceErrorMessageTextView";
        if (access$getCouponPoints$p < 0) {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.priceErrorMessageTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(0);
        } else {
            TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.priceErrorMessageTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str);
            textView3.setVisibility(8);
        }
        TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.totalPriceTextLabel);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "totalPriceTextLabel");
        Sdk27PropertiesKt.setTextColor(textView4, ContextCompat.getColor(this.this$0, C0006R$color.gray6));
    }
}
