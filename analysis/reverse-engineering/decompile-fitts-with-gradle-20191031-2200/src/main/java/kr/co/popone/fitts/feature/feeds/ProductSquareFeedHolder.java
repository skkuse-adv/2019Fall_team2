package kr.co.popone.fitts.feature.feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.model.datamodel.action.ProductAction;
import kr.co.popone.fitts.model.datamodel.action.ProductLikeAction;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductSquareFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private Disposable disposable;
    private final RoundImageView productFeedCoverImageView;
    private final TextView productFeedDcPercentageTextView;
    private final ImageView productFeedLikeImageView;
    private final TextView productFeedOgPriceTextView;
    private final TextView productFeedSalePriceTextView;
    private final TextView productFeedTitleTextView;

    public interface Delegate extends ProductLikeAction, ProductAction {
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_store_grid;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductSquareFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_grid, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductSquareFeedHolder(inflate, delegate);
        }
    }

    public ProductSquareFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.productFeedTitleTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_title);
        this.productFeedCoverImageView = (RoundImageView) view.findViewById(C0010R$id.iv_product_feed_cover);
        this.productFeedOgPriceTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_original_percentage);
        this.productFeedSalePriceTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_sale_price);
        this.productFeedDcPercentageTextView = (TextView) view.findViewById(C0010R$id.tv_product_feed_discount_percentage);
        this.productFeedLikeImageView = (ImageView) view.findViewById(C0010R$id.iv_product_feed_like);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Product) {
            updateProductRectanngleFeedUi((Product) t);
        }
    }

    public void clear() {
        Disposable disposable2 = this.disposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.productFeedCoverImageView);
    }

    private final void updateProductRectanngleFeedUi(Product product) {
        RoundImageView roundImageView = this.productFeedCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "productFeedCoverImageView");
        ImageViewExtensionKt.loadImageAsProduct(roundImageView, product.getShopImageUrl());
        TextView textView = this.productFeedTitleTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "productFeedTitleTextView");
        textView.setText(product.getTitle());
        TextView textView2 = this.productFeedSalePriceTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "productFeedSalePriceTextView");
        textView2.setText(IntExtensionsKt.commaString(product.getSalesPrice()));
        TextView textView3 = this.productFeedOgPriceTextView;
        String str = "productFeedOgPriceTextView";
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        textView3.setText(IntExtensionsKt.commaString(product.getOriginPrice()));
        Double discountRate = product.getDiscountRate();
        int ceil = (int) Math.ceil(discountRate != null ? discountRate.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        TextView textView4 = this.productFeedDcPercentageTextView;
        String str2 = "productFeedDcPercentageTextView";
        Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
        textView4.setText(IntExtensionsKt.percentString(ceil));
        TextView textView5 = this.productFeedOgPriceTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView5, str);
        int i = 8;
        textView5.setVisibility(ceil == 0 ? 8 : 0);
        TextView textView6 = this.productFeedDcPercentageTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView6, str2);
        textView6.setVisibility(ceil == 0 ? 8 : 0);
        TextView textView7 = this.productFeedOgPriceTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView7, str);
        if (ceil != 0) {
            i = 0;
        }
        textView7.setVisibility(i);
        updateWishIconState(product.isInWishList());
        this.productFeedLikeImageView.setOnClickListener(new ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$1(product, this));
        this.itemView.setOnClickListener(new ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$2(product, this));
        this.disposable = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(WishStateUpdateEvent.class).filter(new ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$3(product)).observeOn(AndroidSchedulers.mainThread()).subscribe(new ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$3(product, this), ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$5.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void updateWishIconState(boolean z) {
        this.productFeedLikeImageView.setImageResource(z ? C0008R$drawable.img_icon_heart_point : C0008R$drawable.img_icon_heart);
    }
}
