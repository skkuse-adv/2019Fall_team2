package kr.co.popone.fitts.feature.home.feed;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder.Delegate;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class ProductFeedHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ ProductFeedViewData $this_run;

    ProductFeedHolder$bindTo$$inlined$with$lambda$1(ProductFeedViewData productFeedViewData, View view, ProductFeedHolder productFeedHolder, ProductFeedViewData productFeedViewData2, Delegate delegate) {
        this.$this_run = productFeedViewData;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        String storeLinkUrl = this.$this_run.getStoreLinkUrl();
        if (storeLinkUrl != null) {
            this.$delegate$inlined.onProductClicked(storeLinkUrl);
        }
    }
}
