package kr.co.popone.fitts.feature.search.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class FittieSearchResultFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ FittieSearchResultFragment this$0;

    FittieSearchResultFragment$onViewCreated$2(FittieSearchResultFragment fittieSearchResultFragment) {
        this.this$0 = fittieSearchResultFragment;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().refreshFittieSearchResult();
    }
}
