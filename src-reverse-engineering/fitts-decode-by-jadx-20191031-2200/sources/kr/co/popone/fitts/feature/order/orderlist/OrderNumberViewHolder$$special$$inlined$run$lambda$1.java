package kr.co.popone.fitts.feature.order.orderlist;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;

final class OrderNumberViewHolder$$special$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ OrderListDetailViewData $this_run;
    final /* synthetic */ View $this_with$inlined;

    OrderNumberViewHolder$$special$$inlined$run$lambda$1(OrderListDetailViewData orderListDetailViewData, View view) {
        this.$this_run = orderListDetailViewData;
        this.$this_with$inlined = view;
    }

    public final void onClick(View view) {
        Companion.start$default(StoreBrowserActivity.Companion, this.$this_with$inlined.getContext(), this.$this_run.getProductLinkUrl(), "order list", null, null, 24, null);
    }
}
