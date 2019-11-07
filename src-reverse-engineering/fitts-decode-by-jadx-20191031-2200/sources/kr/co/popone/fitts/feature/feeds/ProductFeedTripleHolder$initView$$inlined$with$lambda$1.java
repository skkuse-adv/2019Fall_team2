package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import org.jetbrains.annotations.NotNull;

final class ProductFeedTripleHolder$initView$$inlined$with$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ ProductFeedTripleHolder this$0;

    ProductFeedTripleHolder$initView$$inlined$with$lambda$1(ProductFeedTripleHolder productFeedTripleHolder, FeedVariantInfo feedVariantInfo, ProductTripleFeedView productTripleFeedView) {
        this.this$0 = productFeedTripleHolder;
        this.$item$inlined = feedVariantInfo;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "it");
        String linkUrl = this.$item$inlined.getFeed().getLinkUrl();
        if (linkUrl != null) {
            this.this$0.getDelegate().onProductClick(this.$item$inlined.getFeed().getId(), linkUrl);
        }
    }
}
