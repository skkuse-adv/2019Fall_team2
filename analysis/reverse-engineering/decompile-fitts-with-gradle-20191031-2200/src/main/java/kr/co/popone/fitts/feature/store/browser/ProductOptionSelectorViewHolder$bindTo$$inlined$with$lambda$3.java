package kr.co.popone.fitts.feature.store.browser;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.browser.ProductOptionSelectorViewHolder.Delegate;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;

final class ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$3 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ OrderableOptionViewData $option$inlined;

    ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$3(ProductOptionSelectorViewHolder productOptionSelectorViewHolder, OrderableOptionViewData orderableOptionViewData, Delegate delegate) {
        this.$option$inlined = orderableOptionViewData;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        this.$delegate$inlined.onDeleteOptionClicked(this.$option$inlined);
    }
}
