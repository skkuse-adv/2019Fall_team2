package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.FeedType;

final class ProductRectangleFeedHolder$updateView$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ FeedType $this_run;
    final /* synthetic */ ProductRectangleFeedHolder this$0;

    ProductRectangleFeedHolder$updateView$$inlined$run$lambda$1(FeedType feedType, ProductRectangleFeedHolder productRectangleFeedHolder) {
        this.$this_run = feedType;
        this.this$0 = productRectangleFeedHolder;
    }

    public final void onClick(View view) {
        String mobileLinkUrl = this.$this_run.getMobileLinkUrl();
        if (mobileLinkUrl != null) {
            this.this$0.delegate.onProductClick(this.$this_run.getId(), mobileLinkUrl);
        }
    }
}
