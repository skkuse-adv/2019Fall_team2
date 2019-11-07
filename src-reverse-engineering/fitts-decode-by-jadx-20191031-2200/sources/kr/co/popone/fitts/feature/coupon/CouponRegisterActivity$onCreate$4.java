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

final class CouponRegisterActivity$onCreate$4<T> implements Consumer<Boolean> {
    final /* synthetic */ CouponRegisterActivity this$0;

    CouponRegisterActivity$onCreate$4(CouponRegisterActivity couponRegisterActivity) {
        this.this$0 = couponRegisterActivity;
    }

    public final void accept(Boolean bool) {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        Intrinsics.checkExpressionValueIsNotNull(bool, "isLoading");
        swipeRefreshLayout.setRefreshing(bool.booleanValue());
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.couponCodeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "couponCodeEditText");
        editText.setEnabled(!bool.booleanValue());
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.confirmButton);
        String str = "confirmButton";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setEnabled(!bool.booleanValue());
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.confirmButton);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        Sdk27PropertiesKt.setTextColor(textView2, ContextCompat.getColor(this.this$0, !bool.booleanValue() ? C0006R$color.point : C0006R$color.gray2));
    }
}
