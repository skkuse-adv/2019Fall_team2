package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kr.co.popone.fitts.feature.order.OrderActivity;
import kr.co.popone.fitts.feature.order.OrderActivity.Companion;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData.Type;
import kr.co.popone.fitts.model.order.OrderInfoViewData;

final class StoreBrowserActivity$onCreate$17<T> implements Observer<Pair<? extends OrderInfoViewData, ? extends Long>> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$17(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Pair<OrderInfoViewData, Long> pair) {
        long longExtra = this.this$0.getIntent().getLongExtra(StoreBrowserActivity.KEY_EVENT_ID, -1);
        Companion companion = OrderActivity.Companion;
        StoreBrowserActivity storeBrowserActivity = this.this$0;
        OrderInitialData orderInitialData = new OrderInitialData((OrderInfoViewData) pair.getFirst(), Type.DIRECT, longExtra, (Long) pair.getSecond());
        companion.startActivity(storeBrowserActivity, orderInitialData);
    }
}
