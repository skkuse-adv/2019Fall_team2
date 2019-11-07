package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;

final class ProductFeedDoubleHolder$initView$$inlined$with$lambda$4 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Product $item$inlined;
    final /* synthetic */ ProductFeedDoubleHolder this$0;

    ProductFeedDoubleHolder$initView$$inlined$with$lambda$4(ProductFeedDoubleHolder productFeedDoubleHolder, Product product, ProductDoubleFeedView productDoubleFeedView) {
        this.this$0 = productFeedDoubleHolder;
        this.$item$inlined = product;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "it");
        this.this$0.getDelegate().onProductClick(this.$item$inlined.getId(), this.$item$inlined.getShopLinkUrl());
    }
}
