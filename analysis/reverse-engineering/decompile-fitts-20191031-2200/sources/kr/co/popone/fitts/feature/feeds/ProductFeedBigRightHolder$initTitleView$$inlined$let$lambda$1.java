package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class ProductFeedBigRightHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ ProductFeedBigRightHolder this$0;

    ProductFeedBigRightHolder$initTitleView$$inlined$let$lambda$1(View view, ProductFeedBigRightHolder productFeedBigRightHolder, Feed feed) {
        this.this$0 = productFeedBigRightHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
