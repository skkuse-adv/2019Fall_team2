package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import org.jetbrains.annotations.NotNull;

final class ProductFeedDoubleHolder$initView$$inlined$with$lambda$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ ProductFeedDoubleHolder this$0;

    ProductFeedDoubleHolder$initView$$inlined$with$lambda$2(ProductFeedDoubleHolder productFeedDoubleHolder, FeedVariantInfo feedVariantInfo, ProductDoubleFeedView productDoubleFeedView) {
        this.this$0 = productFeedDoubleHolder;
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
