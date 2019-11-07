package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;

final class ImageFeedHolder$initTitleView$$inlined$let$lambda$2 implements OnClickListener {
    final /* synthetic */ ShopBridgeFeed $item$inlined;
    final /* synthetic */ ImageFeedHolder this$0;

    ImageFeedHolder$initTitleView$$inlined$let$lambda$2(View view, ImageFeedHolder imageFeedHolder, ShopBridgeFeed shopBridgeFeed) {
        this.this$0 = imageFeedHolder;
        this.$item$inlined = shopBridgeFeed;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$item$inlined.getFeed().getScheme());
    }
}
