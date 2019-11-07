package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter.Delegate;

final class UsedCouponHistoryAdapter$onClickListener$1 implements OnClickListener {
    final /* synthetic */ UsedCouponHistoryAdapter this$0;

    UsedCouponHistoryAdapter$onClickListener$1(UsedCouponHistoryAdapter usedCouponHistoryAdapter) {
        this.this$0 = usedCouponHistoryAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "v");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onItemClicked(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
