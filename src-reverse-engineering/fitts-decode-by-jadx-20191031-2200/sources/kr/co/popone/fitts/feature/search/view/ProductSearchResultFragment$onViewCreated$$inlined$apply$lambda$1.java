package kr.co.popone.fitts.feature.search.view;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import kr.co.popone.fitts.feature.search.adapter.ProductSearchResultAdapter;

public final class ProductSearchResultFragment$onViewCreated$$inlined$apply$lambda$1 extends SpanSizeLookup {
    final /* synthetic */ ProductSearchResultAdapter $productResultAdapter$inlined;

    ProductSearchResultFragment$onViewCreated$$inlined$apply$lambda$1(ProductSearchResultAdapter productSearchResultAdapter) {
        this.$productResultAdapter$inlined = productSearchResultAdapter;
    }

    public int getSpanSize(int i) {
        return this.$productResultAdapter$inlined.getSpanSize(i);
    }
}
