package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class ProductTripleHolder$initView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ ProductTripleHolder this$0;

    ProductTripleHolder$initView$$inlined$with$lambda$1(ProductTripleHolder productTripleHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = productTripleHolder;
        this.$item$inlined = feedVariantInfo;
    }

    public final void onClick(View view) {
        String linkUrl = this.$item$inlined.getFeed().getLinkUrl();
        if (linkUrl != null) {
            this.this$0.delegate.onProductClick(this.$item$inlined.getFeed().getId(), linkUrl);
        }
    }
}
