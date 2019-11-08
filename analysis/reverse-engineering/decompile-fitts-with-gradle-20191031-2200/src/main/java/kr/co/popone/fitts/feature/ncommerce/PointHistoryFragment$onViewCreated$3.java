package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;

final class PointHistoryFragment$onViewCreated$3<T> implements Observer<PagedList<PaymentHistory>> {
    final /* synthetic */ PointHistoryFragment this$0;

    PointHistoryFragment$onViewCreated$3(PointHistoryFragment pointHistoryFragment) {
        this.this$0 = pointHistoryFragment;
    }

    public final void onChanged(PagedList<PaymentHistory> pagedList) {
        this.this$0.pointHistoryAdapter.submitList(pagedList);
    }
}
