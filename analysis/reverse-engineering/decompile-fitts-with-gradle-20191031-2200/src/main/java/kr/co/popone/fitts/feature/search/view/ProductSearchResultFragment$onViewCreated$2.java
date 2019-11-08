package kr.co.popone.fitts.feature.search.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class ProductSearchResultFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ ProductSearchResultFragment this$0;

    ProductSearchResultFragment$onViewCreated$2(ProductSearchResultFragment productSearchResultFragment) {
        this.this$0 = productSearchResultFragment;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().refreshProductSearchResult();
    }
}
