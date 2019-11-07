package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class ProductFeedDoubleHolder$initView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ ProductFeedDoubleHolder this$0;

    ProductFeedDoubleHolder$initView$$inlined$with$lambda$1(ProductFeedDoubleHolder productFeedDoubleHolder, FeedVariantInfo feedVariantInfo, ProductDoubleFeedView productDoubleFeedView) {
        this.this$0 = productFeedDoubleHolder;
        this.$item$inlined = feedVariantInfo;
    }

    public final void onClick(View view) {
        if (Intrinsics.areEqual((Object) this.$item$inlined.getFeed().isInWishList(), (Object) Boolean.valueOf(true))) {
            this.this$0.getDelegate().onRemoveLikeProduct(this.$item$inlined.getFeed().getId());
        } else {
            this.this$0.getDelegate().onAddLikeProduct(this.$item$inlined.getFeed().getId());
        }
    }
}
