package kr.co.popone.fitts.feature.feeds.title;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.post.PostFeedViewData;

final class SimplePostHolder$initView$2 implements OnClickListener {
    final /* synthetic */ PostFeedViewData $item;
    final /* synthetic */ SimplePostHolder this$0;

    SimplePostHolder$initView$2(SimplePostHolder simplePostHolder, PostFeedViewData postFeedViewData) {
        this.this$0 = simplePostHolder;
        this.$item = postFeedViewData;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onPostClick(this.$item.getPostId());
    }
}
