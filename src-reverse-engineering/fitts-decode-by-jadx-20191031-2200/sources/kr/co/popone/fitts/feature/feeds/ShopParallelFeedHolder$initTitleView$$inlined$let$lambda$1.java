package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class ShopParallelFeedHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ ShopParallelFeedHolder this$0;

    ShopParallelFeedHolder$initTitleView$$inlined$let$lambda$1(View view, ShopParallelFeedHolder shopParallelFeedHolder, Feed feed) {
        this.this$0 = shopParallelFeedHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
