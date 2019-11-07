package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class PointUsageHistoryFragment$onViewCreated$3<T> implements Observer<PagedList<PaymentUsage>> {
    final /* synthetic */ PointUsageHistoryFragment this$0;

    PointUsageHistoryFragment$onViewCreated$3(PointUsageHistoryFragment pointUsageHistoryFragment) {
        this.this$0 = pointUsageHistoryFragment;
    }

    public final void onChanged(PagedList<PaymentUsage> pagedList) {
        this.this$0.pointUsageHistoryAdapter.submitList(pagedList);
    }
}
