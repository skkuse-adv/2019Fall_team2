package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.feature.search.adapter.ProductSearchResultAdapter;
import kr.co.popone.fitts.model.search.SearchResult;

final class ProductSearchResultFragment$onViewCreated$4<T> implements Observer<PagedList<SearchResult>> {
    final /* synthetic */ ProductSearchResultAdapter $productResultAdapter;

    ProductSearchResultFragment$onViewCreated$4(ProductSearchResultAdapter productSearchResultAdapter) {
        this.$productResultAdapter = productSearchResultAdapter;
    }

    public final void onChanged(PagedList<SearchResult> pagedList) {
        this.$productResultAdapter.submitList(pagedList);
    }
}
