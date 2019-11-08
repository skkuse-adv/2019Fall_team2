package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;

final class StoreBrowserActivity$onCreate$9<T> implements Observer<OrderableOptionViewData> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$9(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(OrderableOptionViewData orderableOptionViewData) {
        if (orderableOptionViewData != null) {
            this.this$0.getOptionSelectDialog().orderableOptionCreatead(orderableOptionViewData);
        }
    }
}
