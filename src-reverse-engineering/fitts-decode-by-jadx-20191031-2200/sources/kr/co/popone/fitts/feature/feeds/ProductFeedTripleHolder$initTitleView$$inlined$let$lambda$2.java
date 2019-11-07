package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;

final class ProductFeedTripleHolder$initTitleView$$inlined$let$lambda$2 implements OnClickListener {
    final /* synthetic */ ShopBridgeFeed $item$inlined;
    final /* synthetic */ ProductFeedTripleHolder this$0;

    ProductFeedTripleHolder$initTitleView$$inlined$let$lambda$2(View view, ProductFeedTripleHolder productFeedTripleHolder, ShopBridgeFeed shopBridgeFeed) {
        this.this$0 = productFeedTripleHolder;
        this.$item$inlined = shopBridgeFeed;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onSchemeClick(this.this$0, this.$item$inlined.getFeed().getScheme());
    }
}
