package kr.co.popone.fitts.feature.search.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class PostSearchResultFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ PostSearchResultFragment this$0;

    PostSearchResultFragment$onViewCreated$2(PostSearchResultFragment postSearchResultFragment) {
        this.this$0 = postSearchResultFragment;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().refreshPostSearchResult();
    }
}
