package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

final class ProductFeedDoubleHolder$rightProduct$2 extends Lambda implements Function0<ProductDoubleFeedView> {
    final /* synthetic */ View $itemView;

    ProductFeedDoubleHolder$rightProduct$2(View view) {
        this.$itemView = view;
        super(0);
    }

    @NotNull
    public final ProductDoubleFeedView invoke() {
        View findViewById = this.$itemView.findViewById(C0010R$id.view_right);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "this");
        RoundImageView roundImageView = (RoundImageView) findViewById.findViewById(C0010R$id.iv_product_feed_cover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "iv_product_feed_cover");
        TextView textView = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_product_feed_title");
        TextView textView2 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_discount_percentage);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_product_feed_discount_percentage");
        TextView textView3 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_sale_price);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_product_feed_sale_price");
        TextView textView4 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_original_percentage);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_product_feed_original_percentage");
        ImageView imageView = (ImageView) findViewById.findViewById(C0010R$id.iv_product_feed_like);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "iv_product_feed_like");
        ProductDoubleFeedView productDoubleFeedView = new ProductDoubleFeedView(findViewById, roundImageView, textView, textView2, textView3, textView4, imageView);
        return productDoubleFeedView;
    }
}
