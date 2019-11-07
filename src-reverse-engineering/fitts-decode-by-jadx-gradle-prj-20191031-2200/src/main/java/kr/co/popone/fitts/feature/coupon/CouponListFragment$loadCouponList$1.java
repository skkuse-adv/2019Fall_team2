package kr.co.popone.fitts.feature.coupon;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;

final class CouponListFragment$loadCouponList$1<T1, T2> implements BiConsumer<List<? extends CouponInfo>, Throwable> {
    final /* synthetic */ CouponListFragment this$0;

    CouponListFragment$loadCouponList$1(CouponListFragment couponListFragment) {
        this.this$0 = couponListFragment;
    }

    public final void accept(List<CouponInfo> list, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("couponInfoList Response(");
        sb.append(list);
        sb.append(") error(");
        sb.append(th);
        sb.append(')');
        String sb2 = sb.toString();
        boolean z = false;
        Logger.d(sb2, new Object[0]);
        this.this$0.couponInfoListRequest = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((CouponListAdapter) adapter).setShowsLoading(false);
            if (list != null) {
                CouponListFragment couponListFragment = this.this$0;
                couponListFragment.couponInfoList = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) couponListFragment.couponInfoList, (Iterable<? extends T>) list);
                CouponListFragment couponListFragment2 = this.this$0;
                if (list.size() >= 20) {
                    z = true;
                }
                couponListFragment2.hasMoreCouponList = z;
                this.this$0.updateUsedCouponHistoryViews();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.coupon.CouponListAdapter");
    }
}
