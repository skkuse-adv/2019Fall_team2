package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class PostFeedBigRightHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ PostFeedBigRightHolder this$0;

    PostFeedBigRightHolder$initTitleView$$inlined$let$lambda$1(View view, PostFeedBigRightHolder postFeedBigRightHolder, Feed feed) {
        this.this$0 = postFeedBigRightHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
