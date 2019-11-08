package kr.co.popone.fitts.feature.order.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;

final class OrderDetailProductViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ OrderListDetailViewData $this_run;
    final /* synthetic */ View $this_with$inlined;

    OrderDetailProductViewHolder$bindTo$$inlined$with$lambda$1(OrderListDetailViewData orderListDetailViewData, View view, OrderDetailProductViewHolder orderDetailProductViewHolder, int i, OrderListDetailViewData orderListDetailViewData2) {
        this.$this_run = orderListDetailViewData;
        this.$this_with$inlined = view;
    }

    public final void onClick(View view) {
        Companion.start$default(StoreBrowserActivity.Companion, this.$this_with$inlined.getContext(), this.$this_run.getProductLinkUrl(), "order detail", null, null, 24, null);
    }
}
