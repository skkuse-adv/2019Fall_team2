package kr.co.popone.fitts.feature.feeds.title;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;

final class SimplePostHolder$initView$3 implements OnClickListener {
    final /* synthetic */ PostSearchResult $item;
    final /* synthetic */ SimplePostHolder this$0;

    SimplePostHolder$initView$3(SimplePostHolder simplePostHolder, PostSearchResult postSearchResult) {
        this.this$0 = simplePostHolder;
        this.$item = postSearchResult;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onPostClick(this.$item.getPost().getId());
    }
}
