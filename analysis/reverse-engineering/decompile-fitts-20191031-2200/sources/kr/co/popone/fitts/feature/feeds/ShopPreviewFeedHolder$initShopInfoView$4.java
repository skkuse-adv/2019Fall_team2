package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class ShopPreviewFeedHolder$initShopInfoView$4 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item;
    final /* synthetic */ ShopPreviewFeedHolder this$0;

    ShopPreviewFeedHolder$initShopInfoView$4(ShopPreviewFeedHolder shopPreviewFeedHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = shopPreviewFeedHolder;
        this.$item = feedVariantInfo;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onShopClick(this.$item.getFeed().getId());
    }
}
