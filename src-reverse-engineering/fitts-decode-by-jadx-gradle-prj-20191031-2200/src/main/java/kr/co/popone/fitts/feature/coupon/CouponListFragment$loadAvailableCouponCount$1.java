package kr.co.popone.fitts.feature.coupon;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.coupon.CouponAPI.AvailableCouponCountResponse;

final class CouponListFragment$loadAvailableCouponCount$1<T1, T2> implements BiConsumer<AvailableCouponCountResponse, Throwable> {
    final /* synthetic */ CouponListFragment this$0;

    CouponListFragment$loadAvailableCouponCount$1(CouponListFragment couponListFragment) {
        this.this$0 = couponListFragment;
    }

    public final void accept(AvailableCouponCountResponse availableCouponCountResponse, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("availableCouponCount Response(");
        sb.append(availableCouponCountResponse);
        sb.append(") error(");
        sb.append(th);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.availableCouponCountRequest = null;
        if (availableCouponCountResponse != null) {
            this.this$0.availableCouponCount = availableCouponCountResponse.getCount();
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
            }
        }
    }
}
