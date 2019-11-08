package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class ShopPreviewFeedHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ ShopPreviewFeedHolder this$0;

    ShopPreviewFeedHolder$initTitleView$$inlined$let$lambda$1(View view, ShopPreviewFeedHolder shopPreviewFeedHolder, Feed feed) {
        this.this$0 = shopPreviewFeedHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
