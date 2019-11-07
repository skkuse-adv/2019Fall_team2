package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

final class ProductSearchResultFragment$onViewCreated$6<T> implements Observer<Boolean> {
    final /* synthetic */ ProductSearchResultFragment this$0;

    ProductSearchResultFragment$onViewCreated$6(ProductSearchResultFragment productSearchResultFragment) {
        this.this$0 = productSearchResultFragment;
    }

    public final void onChanged(Boolean bool) {
        ProductSearchResultFragment productSearchResultFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        productSearchResultFragment.updateEmptyList(bool.booleanValue());
    }
}
