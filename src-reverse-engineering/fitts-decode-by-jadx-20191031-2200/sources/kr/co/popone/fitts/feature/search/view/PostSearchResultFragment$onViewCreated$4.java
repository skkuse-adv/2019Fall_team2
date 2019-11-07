package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.feature.search.adapter.PostResultAdapter;
import kr.co.popone.fitts.model.search.SearchResult;

final class PostSearchResultFragment$onViewCreated$4<T> implements Observer<PagedList<SearchResult>> {
    final /* synthetic */ PostResultAdapter $postResultAdapter;

    PostSearchResultFragment$onViewCreated$4(PostResultAdapter postResultAdapter) {
        this.$postResultAdapter = postResultAdapter;
    }

    public final void onChanged(PagedList<SearchResult> pagedList) {
        this.$postResultAdapter.submitList(pagedList);
    }
}
