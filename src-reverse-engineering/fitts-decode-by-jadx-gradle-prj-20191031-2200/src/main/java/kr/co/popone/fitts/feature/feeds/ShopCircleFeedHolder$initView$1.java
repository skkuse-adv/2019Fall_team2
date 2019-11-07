package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;

final class ShopCircleFeedHolder$initView$1 implements OnClickListener {
    final /* synthetic */ FeedVariant $item;
    final /* synthetic */ ShopCircleFeedHolder this$0;

    ShopCircleFeedHolder$initView$1(ShopCircleFeedHolder shopCircleFeedHolder, FeedVariant feedVariant) {
        this.this$0 = shopCircleFeedHolder;
        this.$item = feedVariant;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onShopClick(this.$item.getId());
    }
}
