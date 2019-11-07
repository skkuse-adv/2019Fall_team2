package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.ProductAction;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedTripleHolder extends BaseViewHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    private final Lazy centerPost$delegate;
    @NotNull
    private final Delegate delegate;
    private final FrameLayout headerArea;
    private final Lazy leftPost$delegate;
    private final Lazy rightPost$delegate;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_product_triple;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductFeedTripleHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_product_triple, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductFeedTripleHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, ProductAction, SchemeAction {
    }

    static {
        Class<ProductFeedTripleHolder> cls = ProductFeedTripleHolder.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "leftPost", "getLeftPost()Lkr/co/popone/fitts/model/datamodel/service/view/ProductTripleFeedView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "centerPost", "getCenterPost()Lkr/co/popone/fitts/model/datamodel/service/view/ProductTripleFeedView;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "rightPost", "getRightPost()Lkr/co/popone/fitts/model/datamodel/service/view/ProductTripleFeedView;"))};
    }

    private final ProductTripleFeedView getCenterPost() {
        Lazy lazy = this.centerPost$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ProductTripleFeedView) lazy.getValue();
    }

    private final ProductTripleFeedView getLeftPost() {
        Lazy lazy = this.leftPost$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ProductTripleFeedView) lazy.getValue();
    }

    private final ProductTripleFeedView getRightPost() {
        Lazy lazy = this.rightPost$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (ProductTripleFeedView) lazy.getValue();
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public ProductFeedTripleHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.leftPost$delegate = LazyKt__LazyJVMKt.lazy(new ProductFeedTripleHolder$leftPost$2(view));
        this.centerPost$delegate = LazyKt__LazyJVMKt.lazy(new ProductFeedTripleHolder$centerPost$2(view));
        this.rightPost$delegate = LazyKt__LazyJVMKt.lazy(new ProductFeedTripleHolder$rightPost$2(view));
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        } else if (t instanceof ShopBridgeFeed) {
            initView((ShopBridgeFeed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        initView(getLeftPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        initView(getCenterPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
        initView(getRightPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 2));
    }

    private final void initView(ShopBridgeFeed shopBridgeFeed) {
        initTitleView(shopBridgeFeed);
        initView(getLeftPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(shopBridgeFeed.getFeed().getFeeds(), 0));
        initView(getCenterPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(shopBridgeFeed.getFeed().getFeeds(), 1));
        initView(getRightPost(), (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(shopBridgeFeed.getFeed().getFeeds(), 2));
    }

    private final void initView(ProductTripleFeedView productTripleFeedView, FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo == null || feedVariantInfo.getFeed().isEmptyProduct()) {
            productTripleFeedView.invisible();
            return;
        }
        ImageViewExtensionKt.loadImageAsProduct(productTripleFeedView.getCoverImageView(), feedVariantInfo.getFeed().getImageUrl());
        productTripleFeedView.getTitleTextView().setText(feedVariantInfo.getFeed().getTitle());
        TextView priceTextView = productTripleFeedView.getPriceTextView();
        Long salesPrice = feedVariantInfo.getFeed().getSalesPrice();
        String str = null;
        priceTextView.setText(salesPrice != null ? IntExtensionsKt.commaString(salesPrice.longValue()) : null);
        TextView discountPercetageTextView = productTripleFeedView.getDiscountPercetageTextView();
        Double discountRate = feedVariantInfo.getFeed().getDiscountRate();
        if (discountRate != null) {
            str = IntExtensionsKt.percentString(discountRate.doubleValue());
        }
        discountPercetageTextView.setText(str);
        if (feedVariantInfo.getFeed().isDiscount()) {
            ViewExtensionsKt.visible(productTripleFeedView.getDiscountPercetageTextView());
        } else {
            ViewExtensionsKt.gone(productTripleFeedView.getDiscountPercetageTextView());
        }
        productTripleFeedView.setOnClickListener(new ProductFeedTripleHolder$initView$$inlined$with$lambda$1(this, feedVariantInfo, productTripleFeedView));
        productTripleFeedView.visible();
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
            frameLayout.setOnClickListener(new ProductFeedTripleHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    private final void initTitleView(ShopBridgeFeed shopBridgeFeed) {
        Feed feed = shopBridgeFeed.getFeed();
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
        View shopBridgeTitleView = feed.getShopBridgeTitleView(context, shopBridgeFeed.getShopName(), this.delegate.getSessionManager());
        if (shopBridgeTitleView != null) {
            FrameLayout frameLayout = this.headerArea;
            ViewExtensionsKt.visible(frameLayout);
            frameLayout.removeAllViews();
            frameLayout.addView(shopBridgeTitleView);
            frameLayout.setOnClickListener(new ProductFeedTripleHolder$initTitleView$$inlined$let$lambda$2(shopBridgeTitleView, this, shopBridgeFeed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        clearView(getLeftPost());
        clearView(getCenterPost());
        clearView(getRightPost());
        this.headerArea.removeAllViews();
    }

    private final void clearView(ProductTripleFeedView productTripleFeedView) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) productTripleFeedView.getCoverImageView());
        productTripleFeedView.getTitleTextView().setText(null);
        productTripleFeedView.getPriceTextView().setText(null);
        productTripleFeedView.getDiscountPercetageTextView().setText(null);
    }
}
