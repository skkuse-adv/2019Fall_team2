package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.ProductAction;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.ProductFeedView;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedBigLeftHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    private final ProductFeedView bigProduct;
    private final ProductFeedView bottomProduct;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final ProductFeedView topProduct;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_feed_product_big_left;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductFeedBigLeftHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_feed_product_big_left, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductFeedBigLeftHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, ProductAction, SchemeAction {
    }

    public ProductFeedBigLeftHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        View findViewById = view.findViewById(C0010R$id.viewBigProductCover);
        String str = "itemView.viewBigProductCover";
        Intrinsics.checkExpressionValueIsNotNull(findViewById, str);
        View findViewById2 = view.findViewById(C0010R$id.viewBigProductCover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, str);
        RoundImageView roundImageView = (RoundImageView) findViewById2.findViewById(C0010R$id.ivProductCoverBig);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "itemView.viewBigProductCover.ivProductCoverBig");
        View findViewById3 = view.findViewById(C0010R$id.viewBigProductCover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, str);
        TextView textView = (TextView) findViewById3.findViewById(C0010R$id.tvProductPriceBig);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.viewBigProductCover.tvProductPriceBig");
        View findViewById4 = view.findViewById(C0010R$id.viewBigProductCover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, str);
        Group group = (Group) findViewById4.findViewById(C0010R$id.grProductPriceBig);
        Intrinsics.checkExpressionValueIsNotNull(group, "itemView.viewBigProductCover.grProductPriceBig");
        this.bigProduct = new ProductFeedView(findViewById, roundImageView, textView, group);
        View findViewById5 = view.findViewById(C0010R$id.viewNormalProductTop);
        String str2 = "itemView.viewNormalProductTop";
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, str2);
        View findViewById6 = view.findViewById(C0010R$id.viewNormalProductTop);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, str2);
        RoundImageView roundImageView2 = (RoundImageView) findViewById6.findViewById(C0010R$id.ivProductCoverSmall);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView2, "itemView.viewNormalProductTop.ivProductCoverSmall");
        View findViewById7 = view.findViewById(C0010R$id.viewNormalProductTop);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, str2);
        TextView textView2 = (TextView) findViewById7.findViewById(C0010R$id.tvProductPriceSmall);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.viewNormalProductTop.tvProductPriceSmall");
        View findViewById8 = view.findViewById(C0010R$id.viewNormalProductTop);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, str2);
        Group group2 = (Group) findViewById8.findViewById(C0010R$id.grProductPriceSmall);
        Intrinsics.checkExpressionValueIsNotNull(group2, "itemView.viewNormalProductTop.grProductPriceSmall");
        this.topProduct = new ProductFeedView(findViewById5, roundImageView2, textView2, group2);
        View findViewById9 = view.findViewById(C0010R$id.viewNormalProductBottom);
        String str3 = "itemView.viewNormalProductBottom";
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, str3);
        View findViewById10 = view.findViewById(C0010R$id.viewNormalProductBottom);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, str3);
        RoundImageView roundImageView3 = (RoundImageView) findViewById10.findViewById(C0010R$id.ivProductCoverSmall);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView3, "itemView.viewNormalProdu…ottom.ivProductCoverSmall");
        View findViewById11 = view.findViewById(C0010R$id.viewNormalProductBottom);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, str3);
        TextView textView3 = (TextView) findViewById11.findViewById(C0010R$id.tvProductPriceSmall);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.viewNormalProdu…ottom.tvProductPriceSmall");
        View findViewById12 = view.findViewById(C0010R$id.viewNormalProductBottom);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, str3);
        Group group3 = (Group) findViewById12.findViewById(C0010R$id.grProductPriceSmall);
        Intrinsics.checkExpressionValueIsNotNull(group3, "itemView.viewNormalProdu…ottom.grProductPriceSmall");
        this.bottomProduct = new ProductFeedView(findViewById9, roundImageView3, textView3, group3);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        initView(this.bigProduct, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        initView(this.topProduct, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
        initView(this.bottomProduct, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 2));
    }

    private final void initView(ProductFeedView productFeedView, FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo == null || feedVariantInfo.getFeed().isEmptyProduct()) {
            ViewExtensionsKt.invisible(productFeedView.getImageView());
            ViewExtensionsKt.invisible(productFeedView.getTitleGroup());
            return;
        }
        ImageView imageView = productFeedView.getImageView();
        ImageViewExtensionKt.loadImageAsProduct(imageView, feedVariantInfo.getFeed().getImageUrl());
        imageView.setOnClickListener(new ProductFeedBigLeftHolder$initView$$inlined$with$lambda$1(this, feedVariantInfo));
        ViewExtensionsKt.visible(imageView);
        Long salesPrice = feedVariantInfo.getFeed().getSalesPrice();
        if (salesPrice != null) {
            String commaString = IntExtensionsKt.commaString(salesPrice.longValue());
            if (commaString != null) {
                productFeedView.getTitleView().setText(commaString);
                ViewExtensionsKt.visible(productFeedView.getTitleGroup());
                return;
            }
        }
        ViewExtensionsKt.invisible(productFeedView.getTitleGroup());
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
            frameLayout.setOnClickListener(new ProductFeedBigLeftHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        clear(this.bigProduct);
        clear(this.topProduct);
        clear(this.bottomProduct);
        this.headerArea.removeAllViews();
    }

    private final void clear(ProductFeedView productFeedView) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) productFeedView.getImageView());
    }
}
