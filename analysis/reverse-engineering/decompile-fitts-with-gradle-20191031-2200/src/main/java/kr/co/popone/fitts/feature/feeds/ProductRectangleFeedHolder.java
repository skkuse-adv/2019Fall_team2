package kr.co.popone.fitts.feature.feeds;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.action.ProductAction;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.FeedType;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductRectangleFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final RoundImageView productFeedCoverImageView;
    private final TextView productFeedDcPercentageTextView;
    private final TextView productFeedSalePriceTextView;
    private final TextView productFeedTitleTextView;

    public interface Delegate extends ProductAction {
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_product_rectangle;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductRectangleFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_product_rectangle, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductRectangleFeedHolder(inflate, delegate);
        }
    }

    public ProductRectangleFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.productFeedCoverImageView = (RoundImageView) view.findViewById(C0010R$id.iv_product_feed_cover);
        this.productFeedTitleTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_title);
        this.productFeedSalePriceTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_sale_price);
        this.productFeedDcPercentageTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_discount_percentage);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof FeedType) {
            updateView((FeedType) t);
        } else if (t instanceof Product) {
            updateView((Product) t);
        }
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.productFeedCoverImageView);
    }

    @SuppressLint({"SetTextI18n"})
    private final void updateView(FeedType feedType) {
        RoundImageView roundImageView = this.productFeedCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "productFeedCoverImageView");
        ImageViewExtensionKt.loadImageAsProduct(roundImageView, feedType.getImageUrl());
        Integer discountPercentage = feedType.getDiscountPercentage();
        String str = "productFeedDcPercentageTextView";
        if (discountPercentage != null && discountPercentage.intValue() == 0) {
            TextView textView = this.productFeedDcPercentageTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            ViewExtensionsKt.gone(textView);
        } else {
            TextView textView2 = this.productFeedDcPercentageTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            ViewExtensionsKt.visible(textView2);
        }
        TextView textView3 = this.productFeedDcPercentageTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        StringBuilder sb = new StringBuilder();
        sb.append(feedType.getDiscountPercentage());
        sb.append('%');
        textView3.setText(sb.toString());
        TextView textView4 = this.productFeedTitleTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView4, "productFeedTitleTextView");
        textView4.setText(feedType.getTitle());
        TextView textView5 = this.productFeedSalePriceTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView5, "productFeedSalePriceTextView");
        textView5.setText(IntExtensionsKt.commaString(feedType.getSalsePrice()));
        this.itemView.setOnClickListener(new ProductRectangleFeedHolder$updateView$$inlined$run$lambda$1(feedType, this));
    }

    @SuppressLint({"SetTextI18n"})
    private final void updateView(Product product) {
        RoundImageView roundImageView = this.productFeedCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "productFeedCoverImageView");
        ImageViewExtensionKt.loadImageAsProduct(roundImageView, product.getShopImageUrl());
        Double discountRate = product.getDiscountRate();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        String str = "productFeedDcPercentageTextView";
        if (Intrinsics.areEqual(discountRate, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            TextView textView = this.productFeedDcPercentageTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            ViewExtensionsKt.gone(textView);
        } else {
            TextView textView2 = this.productFeedDcPercentageTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            ViewExtensionsKt.visible(textView2);
        }
        Double discountRate2 = product.getDiscountRate();
        if (discountRate2 != null) {
            d = discountRate2.doubleValue();
        }
        int ceil = (int) Math.ceil(d);
        TextView textView3 = this.productFeedDcPercentageTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        textView3.setText(IntExtensionsKt.percentString(ceil));
        TextView textView4 = this.productFeedTitleTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView4, "productFeedTitleTextView");
        textView4.setText(product.getTitle());
        TextView textView5 = this.productFeedSalePriceTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView5, "productFeedSalePriceTextView");
        textView5.setText(IntExtensionsKt.commaString(product.getSalesPrice()));
        this.itemView.setOnClickListener(new ProductRectangleFeedHolder$updateView$$inlined$run$lambda$2(product, this));
    }
}
