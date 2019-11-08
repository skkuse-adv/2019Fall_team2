package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class ProductFeedDoubleHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ ProductFeedDoubleHolder this$0;

    ProductFeedDoubleHolder$initTitleView$$inlined$let$lambda$1(View view, ProductFeedDoubleHolder productFeedDoubleHolder, Feed feed) {
        this.this$0 = productFeedDoubleHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
