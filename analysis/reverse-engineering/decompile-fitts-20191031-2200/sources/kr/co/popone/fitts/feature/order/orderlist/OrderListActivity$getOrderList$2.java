package kr.co.popone.fitts.feature.order.orderlist;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.order.OrderListViewData;

final class OrderListActivity$getOrderList$2<T> implements Observer<PagedList<OrderListViewData>> {
    final /* synthetic */ OrderListActivity this$0;

    OrderListActivity$getOrderList$2(OrderListActivity orderListActivity) {
        this.this$0 = orderListActivity;
    }

    public final void onChanged(PagedList<OrderListViewData> pagedList) {
        this.this$0.orderListAdapter.submitList(pagedList);
    }
}
