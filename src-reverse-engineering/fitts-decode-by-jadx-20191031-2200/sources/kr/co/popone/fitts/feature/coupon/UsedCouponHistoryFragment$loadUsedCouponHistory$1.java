package kr.co.popone.fitts.feature.coupon;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class UsedCouponHistoryFragment$loadUsedCouponHistory$1<T1, T2> implements BiConsumer<List<? extends PaymentUsage>, Throwable> {
    final /* synthetic */ UsedCouponHistoryFragment this$0;

    UsedCouponHistoryFragment$loadUsedCouponHistory$1(UsedCouponHistoryFragment usedCouponHistoryFragment) {
        this.this$0 = usedCouponHistoryFragment;
    }

    public final void accept(List<PaymentUsage> list, Throwable th) {
        this.this$0.usedCouponHistoryRequest = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        boolean z = false;
        swipeRefreshLayout.setRefreshing(false);
        if (list != null) {
            UsedCouponHistoryFragment usedCouponHistoryFragment = this.this$0;
            usedCouponHistoryFragment.usedPaymentHistoryList = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) usedCouponHistoryFragment.usedPaymentHistoryList, (Iterable<? extends T>) list);
            UsedCouponHistoryFragment usedCouponHistoryFragment2 = this.this$0;
            if (list.size() >= 20) {
                z = true;
            }
            usedCouponHistoryFragment2.hasMoreUsedCouponHistory = z;
            this.this$0.updateUsedCouponHistoryViews();
        }
    }
}
