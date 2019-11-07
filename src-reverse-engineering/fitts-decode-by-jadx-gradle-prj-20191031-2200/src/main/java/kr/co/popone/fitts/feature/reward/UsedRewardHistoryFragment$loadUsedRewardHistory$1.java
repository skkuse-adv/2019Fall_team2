package kr.co.popone.fitts.feature.reward;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class UsedRewardHistoryFragment$loadUsedRewardHistory$1<T1, T2> implements BiConsumer<List<? extends PaymentUsage>, Throwable> {
    final /* synthetic */ UsedRewardHistoryFragment this$0;

    UsedRewardHistoryFragment$loadUsedRewardHistory$1(UsedRewardHistoryFragment usedRewardHistoryFragment) {
        this.this$0 = usedRewardHistoryFragment;
    }

    public final void accept(List<PaymentUsage> list, Throwable th) {
        this.this$0.usedRewardHistoryRequest = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        boolean z = false;
        swipeRefreshLayout.setRefreshing(false);
        if (list != null) {
            UsedRewardHistoryFragment usedRewardHistoryFragment = this.this$0;
            usedRewardHistoryFragment.usedRewardHistoryList = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) usedRewardHistoryFragment.usedRewardHistoryList, (Iterable<? extends T>) list);
            UsedRewardHistoryFragment usedRewardHistoryFragment2 = this.this$0;
            if (list.size() >= 20) {
                z = true;
            }
            usedRewardHistoryFragment2.hasMoreUsedRewardHistory = z;
            this.this$0.updateUsedRewardHistoryViews();
        }
    }
}
