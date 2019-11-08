package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class ShopPreviewFeedHolder$initShopInfoView$3 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item;
    final /* synthetic */ ShopPreviewFeedHolder this$0;

    ShopPreviewFeedHolder$initShopInfoView$3(ShopPreviewFeedHolder shopPreviewFeedHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = shopPreviewFeedHolder;
        this.$item = feedVariantInfo;
    }

    public final void onClick(View view) {
        if (this.$item.getFeed().isShopFavorite()) {
            this.this$0.delegate.onRemoveShopBookmark(this.$item.getFeed().getId());
        } else {
            this.this$0.delegate.onAddShopBookmark(this.$item.getFeed().getId());
        }
    }
}
