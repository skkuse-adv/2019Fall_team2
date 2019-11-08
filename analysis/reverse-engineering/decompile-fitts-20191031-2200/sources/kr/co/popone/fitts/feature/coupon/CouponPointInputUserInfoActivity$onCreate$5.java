package kr.co.popone.fitts.feature.coupon;

import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.anko.Sdk27PropertiesKt;

final class CouponPointInputUserInfoActivity$onCreate$5<T> implements Consumer<Boolean> {
    final /* synthetic */ CouponPointInputUserInfoActivity this$0;

    CouponPointInputUserInfoActivity$onCreate$5(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
        this.this$0 = couponPointInputUserInfoActivity;
    }

    public final void accept(Boolean bool) {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        swipeRefreshLayout.setRefreshing(bool.booleanValue());
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userNameEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
        editText.setEnabled(!bool.booleanValue());
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userPhoneEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
        editText2.setEnabled(!bool.booleanValue());
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.confirmButton);
        String str = "confirmButton";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setEnabled(!bool.booleanValue());
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.confirmButton);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        Sdk27PropertiesKt.setTextColor(textView2, ContextCompat.getColor(this.this$0, !bool.booleanValue() ? C0006R$color.point : C0006R$color.gray2));
    }
}
