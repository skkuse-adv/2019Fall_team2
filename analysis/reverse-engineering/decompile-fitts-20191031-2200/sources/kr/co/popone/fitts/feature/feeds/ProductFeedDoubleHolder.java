package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.ProductAction;
import kr.co.popone.fitts.model.datamodel.action.ProductLikeAction;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedDoubleHolder extends BaseViewHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;
    private final FrameLayout headerArea;
    private final Lazy leftProduct$delegate;
    private final Lazy rightProduct$delegate;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_product_double;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductFeedDoubleHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_product_double, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductFeedDoubleHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, ProductAction, ProductLikeAction, SchemeAction {
    }

    static {
        Class<ProductFeedDoubleHolder> cls = ProductFeedDoubleHolder.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "leftProduct", "getLeftProduct()Lkr/co/popone/fitts/model/datamodel/service/view/ProductDoubleFeedView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "rightProduct", "getRightProduct()Lkr/co/popone/fitts/model/datamodel/service/view/ProductDoubleFeedView;"))};
    }

    private final ProductDoubleFeedView getLeftProduct() {
        Lazy lazy = this.leftProduct$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProductDoubleFeedView) lazy.getValue();
    }

    private final ProductDoubleFeedView getRightProduct() {
        Lazy lazy = this.rightProduct$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ProductDoubleFeedView) lazy.getValue();
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public ProductFeedDoubleHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.leftProduct$delegate = LazyKt__LazyJVMKt.lazy(new ProductFeedDoubleHolder$leftProduct$2(view));
        this.rightProduct$delegate = LazyKt__LazyJVMKt.lazy(new ProductFeedDoubleHolder$rightProduct$2(view));
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        } else if (t instanceof ShopBridgeProduct) {
            initView((ShopBridgeProduct) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        initView(getLeftProduct(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        initView(getRightProduct(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
    }

    private final void initView(ProductDoubleFeedView productDoubleFeedView, FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo == null || feedVariantInfo.getFeed().isEmptyProduct()) {
            productDoubleFeedView.invisible();
            return;
        }
        ImageViewExtensionKt.loadImageAsProduct(productDoubleFeedView.getCoverImageView(), feedVariantInfo.getFeed().getImageUrl());
        productDoubleFeedView.getTitleTextView().setText(feedVariantInfo.getFeed().getTitle());
        TextView salePriceTextView = productDoubleFeedView.getSalePriceTextView();
        Long salesPrice = feedVariantInfo.getFeed().getSalesPrice();
        String str = null;
        salePriceTextView.setText(salesPrice != null ? IntExtensionsKt.commaString(salesPrice.longValue()) : null);
        TextView originPriceTextView = productDoubleFeedView.getOriginPriceTextView();
        Long originPrice = feedVariantInfo.getFeed().getOriginPrice();
        originPriceTextView.setText(originPrice != null ? IntExtensionsKt.commaString(originPrice.longValue()) : null);
        TextView discountPercetageTextView = productDoubleFeedView.getDiscountPercetageTextView();
        Double discountRate = feedVariantInfo.getFeed().getDiscountRate();
        if (discountRate != null) {
            str = IntExtensionsKt.percentString(discountRate.doubleValue());
        }
        discountPercetageTextView.setText(str);
        if (feedVariantInfo.getFeed().isDiscount()) {
            ViewExtensionsKt.visible(productDoubleFeedView.getOriginPriceTextView());
            ViewExtensionsKt.visible(productDoubleFeedView.getDiscountPercetageTextView());
        } else {
            ViewExtensionsKt.gone(productDoubleFeedView.getOriginPriceTextView());
            ViewExtensionsKt.gone(productDoubleFeedView.getDiscountPercetageTextView());
        }
        productDoubleFeedView.updateLikeIcon(feedVariantInfo.getFeed().isInWishList());
        productDoubleFeedView.getWishItemImageView().setOnClickListener(new ProductFeedDoubleHolder$initView$$inlined$with$lambda$1(this, feedVariantInfo, productDoubleFeedView));
        productDoubleFeedView.setOnClickListener(new ProductFeedDoubleHolder$initView$$inlined$with$lambda$2(this, feedVariantInfo, productDoubleFeedView));
        productDoubleFeedView.visible();
    }

    private final void initView(ShopBridgeProduct shopBridgeProduct) {
        initView(getLeftProduct(), (Product) CollectionsKt___CollectionsKt.getOrNull(shopBridgeProduct.getProducts(), 0));
        initView(getRightProduct(), (Product) CollectionsKt___CollectionsKt.getOrNull(shopBridgeProduct.getProducts(), 1));
    }

    private final void initView(ProductDoubleFeedView productDoubleFeedView, Product product) {
        if (product == null || product.isEmptyProduct()) {
            productDoubleFeedView.invisible();
            return;
        }
        ImageViewExtensionKt.loadImageAsProduct(productDoubleFeedView.getCoverImageView(), product.getShopImageUrl());
        productDoubleFeedView.getTitleTextView().setText(product.getTitle());
        productDoubleFeedView.getSalePriceTextView().setText(IntExtensionsKt.commaString(product.getSalesPrice()));
        productDoubleFeedView.getOriginPriceTextView().setText(IntExtensionsKt.commaString(product.getOriginPrice()));
        TextView discountPercetageTextView = productDoubleFeedView.getDiscountPercetageTextView();
        Double discountRate = product.getDiscountRate();
        discountPercetageTextView.setText(discountRate != null ? IntExtensionsKt.percentString(discountRate.doubleValue()) : null);
        if (product.isDiscount()) {
            ViewExtensionsKt.visible(productDoubleFeedView.getOriginPriceTextView());
            ViewExtensionsKt.visible(productDoubleFeedView.getDiscountPercetageTextView());
        } else {
            ViewExtensionsKt.gone(productDoubleFeedView.getOriginPriceTextView());
            ViewExtensionsKt.gone(productDoubleFeedView.getDiscountPercetageTextView());
        }
        productDoubleFeedView.updateLikeIcon(Boolean.valueOf(product.isInWishList()));
        productDoubleFeedView.getWishItemImageView().setOnClickListener(new ProductFeedDoubleHolder$initView$$inlined$with$lambda$3(this, product, productDoubleFeedView));
        productDoubleFeedView.setOnClickListener(new ProductFeedDoubleHolder$initView$$inlined$with$lambda$4(this, product, productDoubleFeedView));
        productDoubleFeedView.visible();
    }

    private final void initTitleView(Feed feed) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
        View titleHeaderView = feed.getTitleHeaderView(context, this.delegate.getSessionManager());
        if (titleHeaderView != null) {
            FrameLayout frameLayout = this.headerArea;
            ViewExtensionsKt.visible(frameLayout);
            frameLayout.removeAllViews();
            frameLayout.addView(titleHeaderView);
            frameLayout.setOnClickListener(new ProductFeedDoubleHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public final void updateFeedState(@NotNull Feed feed) {
        Intrinsics.checkParameterIsNotNull(feed, MessageTemplateProtocol.TYPE_FEED);
        updateLikeProductState(getLeftProduct(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        updateLikeProductState(getRightProduct(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
    }

    public final void updateShopBridgeFeed(@NotNull ShopBridgeProduct shopBridgeProduct) {
        Intrinsics.checkParameterIsNotNull(shopBridgeProduct, "item");
        updateLikeProductState(getLeftProduct(), (Product) CollectionsKt___CollectionsKt.getOrNull(shopBridgeProduct.getProducts(), 0));
        updateLikeProductState(getRightProduct(), (Product) CollectionsKt___CollectionsKt.getOrNull(shopBridgeProduct.getProducts(), 1));
    }

    private final void updateLikeProductState(ProductDoubleFeedView productDoubleFeedView, FeedVariantInfo feedVariantInfo) {
        Boolean bool;
        if (feedVariantInfo != null) {
            FeedVariant feed = feedVariantInfo.getFeed();
            if (feed != null) {
                bool = feed.isInWishList();
                productDoubleFeedView.updateLikeIcon(bool);
            }
        }
        bool = null;
        productDoubleFeedView.updateLikeIcon(bool);
    }

    private final void updateLikeProductState(ProductDoubleFeedView productDoubleFeedView, Product product) {
        productDoubleFeedView.updateLikeIcon(product != null ? Boolean.valueOf(product.isInWishList()) : null);
    }

    public void clear() {
        clearView(getLeftProduct());
        clearView(getRightProduct());
        this.headerArea.removeAllViews();
    }

    private final void clearView(ProductDoubleFeedView productDoubleFeedView) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) productDoubleFeedView.getCoverImageView());
        productDoubleFeedView.getTitleTextView().setText(null);
        productDoubleFeedView.getSalePriceTextView().setText(null);
        productDoubleFeedView.getOriginPriceTextView().setText(null);
        productDoubleFeedView.getDiscountPercetageTextView().setText(null);
    }
}
