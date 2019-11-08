package kr.co.popone.fitts.feature.coupon;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CouponUseActivity$onCreate$3<T> implements Consumer<Boolean> {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$3(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.showUrlLinkButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "showUrlLinkButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        button.setEnabled(bool.booleanValue());
    }
}
