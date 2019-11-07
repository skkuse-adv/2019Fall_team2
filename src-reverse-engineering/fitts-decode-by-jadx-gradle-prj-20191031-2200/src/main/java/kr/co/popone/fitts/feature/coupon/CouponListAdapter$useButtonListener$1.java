package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.coupon.CouponListAdapter.Delegate;

final class CouponListAdapter$useButtonListener$1 implements OnClickListener {
    final /* synthetic */ CouponListAdapter this$0;

    CouponListAdapter$useButtonListener$1(CouponListAdapter couponListAdapter) {
        this.this$0 = couponListAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.useButtonClicked(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
