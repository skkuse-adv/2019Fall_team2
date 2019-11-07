package kr.co.popone.fitts.feature.order.orderlist;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;
import kr.co.popone.fitts.model.order.OrderListViewData;

final class OrderNumberRecyclerHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ OrderListViewData $item$inlined;
    final /* synthetic */ View $this_with$inlined;

    OrderNumberRecyclerHolder$bindTo$$inlined$with$lambda$1(View view, OrderNumberRecyclerHolder orderNumberRecyclerHolder, OrderListViewData orderListViewData) {
        this.$this_with$inlined = view;
        this.$item$inlined = orderListViewData;
    }

    public final void onClick(View view) {
        OrderDetailActivity.Companion.start(this.$this_with$inlined.getContext(), this.$item$inlined.getOrderId());
    }
}
