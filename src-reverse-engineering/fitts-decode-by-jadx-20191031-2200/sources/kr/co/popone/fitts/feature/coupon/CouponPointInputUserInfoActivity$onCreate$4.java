package kr.co.popone.fitts.feature.coupon;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.anko.Sdk27PropertiesKt;

final class CouponPointInputUserInfoActivity$onCreate$4<T> implements Consumer<CharSequence> {
    final /* synthetic */ CouponPointInputUserInfoActivity this$0;

    CouponPointInputUserInfoActivity$onCreate$4(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
        this.this$0 = couponPointInputUserInfoActivity;
    }

    public final void accept(CharSequence charSequence) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.userPhoneTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "userPhoneTextView");
        Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this.this$0, C0006R$color.gray6));
    }
}
