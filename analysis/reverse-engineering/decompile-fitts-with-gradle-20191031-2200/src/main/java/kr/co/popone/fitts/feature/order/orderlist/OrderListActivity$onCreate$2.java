package kr.co.popone.fitts.feature.order.orderlist;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class OrderListActivity$onCreate$2 implements OnRefreshListener {
    final /* synthetic */ OrderListActivity this$0;

    OrderListActivity$onCreate$2(OrderListActivity orderListActivity) {
        this.this$0 = orderListActivity;
    }

    public final void onRefresh() {
        this.this$0.getOrderList();
    }
}
