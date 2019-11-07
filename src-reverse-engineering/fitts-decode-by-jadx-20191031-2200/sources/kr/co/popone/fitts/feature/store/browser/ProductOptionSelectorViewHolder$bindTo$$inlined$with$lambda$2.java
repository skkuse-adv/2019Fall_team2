package kr.co.popone.fitts.feature.store.browser;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.store.browser.ProductOptionSelectorViewHolder.Delegate;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;

final class ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$2 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ OrderableOptionViewData $option$inlined;
    final /* synthetic */ View $this_with;
    final /* synthetic */ ProductOptionSelectorViewHolder this$0;

    ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$2(View view, ProductOptionSelectorViewHolder productOptionSelectorViewHolder, OrderableOptionViewData orderableOptionViewData, Delegate delegate) {
        this.$this_with = view;
        this.this$0 = productOptionSelectorViewHolder;
        this.$option$inlined = orderableOptionViewData;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        OrderableOptionViewData orderableOptionViewData = this.$option$inlined;
        if (orderableOptionViewData.isSpecialDiscount()) {
            this.this$0.showMessageDialog();
            return;
        }
        orderableOptionViewData.setProductCount(orderableOptionViewData.getProductCount() + 1);
        TextView textView = (TextView) this.$this_with.findViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        textView.setText(String.valueOf(orderableOptionViewData.getProductCount()));
        this.$delegate$inlined.onOptionCountChanged(orderableOptionViewData, orderableOptionViewData);
    }
}
