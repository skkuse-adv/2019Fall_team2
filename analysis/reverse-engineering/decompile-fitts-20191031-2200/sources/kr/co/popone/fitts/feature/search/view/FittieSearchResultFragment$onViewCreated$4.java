package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.feature.search.adapter.FittieResultAdapter;
import kr.co.popone.fitts.model.search.SearchResult;

final class FittieSearchResultFragment$onViewCreated$4<T> implements Observer<PagedList<SearchResult>> {
    final /* synthetic */ FittieResultAdapter $fittieResultAdapter;

    FittieSearchResultFragment$onViewCreated$4(FittieResultAdapter fittieResultAdapter) {
        this.$fittieResultAdapter = fittieResultAdapter;
    }

    public final void onChanged(PagedList<SearchResult> pagedList) {
        this.$fittieResultAdapter.submitList(pagedList);
    }
}
