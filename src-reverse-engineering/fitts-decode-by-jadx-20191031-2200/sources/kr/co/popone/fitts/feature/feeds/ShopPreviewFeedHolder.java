package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.kakao.message.template.MessageTemplateProtocol;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.BookmarkAction;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.action.ShopAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopPreviewFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final ImageView productCenterImageView;
    private final ImageView productLeftImageView;
    private final ImageView productRightImageView;
    private final CircleImageView shopCoverImageView;
    private final ImageView shopFavoriteImageView;
    private final TextView shopTitleTextView;
    private final TextView textBodyFeature;
    private final TextView textProductFeature;
    private final TextView textStyleKeywordFirst;
    private final TextView textStyleKeywordSecond;
    private final TextView textStyleKeywordSingle;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_shop_feed_preview;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShopPreviewFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_shop_feed_preview, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ShopPreviewFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends ShopAction, BookmarkAction, SessionProvider, SchemeAction {
    }

    public ShopPreviewFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.imageShopCover);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.imageShopCover");
        this.shopCoverImageView = circleImageView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textShopTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.textShopTitle");
        this.shopTitleTextView = textView;
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textStyleKeywordSingle);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.textStyleKeywordSingle");
        this.textStyleKeywordSingle = textView2;
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textStyleKeywordFirst);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.textStyleKeywordFirst");
        this.textStyleKeywordFirst = textView3;
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textStyleKeywordSecond);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "itemView.textStyleKeywordSecond");
        this.textStyleKeywordSecond = textView4;
        TextView textView5 = (TextView) view.findViewById(C0010R$id.textBodyFeature);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "itemView.textBodyFeature");
        this.textBodyFeature = textView5;
        TextView textView6 = (TextView) view.findViewById(C0010R$id.textProductFeature);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "itemView.textProductFeature");
        this.textProductFeature = textView6;
        ImageView imageView = (ImageView) view.findViewById(C0010R$id.imageShopFavorite);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.imageShopFavorite");
        this.shopFavoriteImageView = imageView;
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageLeft);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "itemView.imageLeft");
        this.productLeftImageView = roundImageView;
        RoundImageView roundImageView2 = (RoundImageView) view.findViewById(C0010R$id.imageCenter);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView2, "itemView.imageCenter");
        this.productCenterImageView = roundImageView2;
        RoundImageView roundImageView3 = (RoundImageView) view.findViewById(C0010R$id.imageRight);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView3, "itemView.imageRight");
        this.productRightImageView = roundImageView3;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "itemView.layoutHeaderView");
        this.headerArea = frameLayout;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        initShopInfoView((FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(feed.getFeeds()));
    }

    private final void initShopInfoView(FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo != null) {
            CircleImageView circleImageView = this.shopCoverImageView;
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
            ImageViewExtensionKt.loadImageAsCircle(circleImageView, context, feedVariantInfo.getFeed().getShopImageInfo().getUrl());
            this.shopTitleTextView.setText(feedVariantInfo.getFeed().getShopName());
            String shopBodyFeature = feedVariantInfo.getFeed().getShopBodyFeature();
            if (shopBodyFeature != null) {
                this.textBodyFeature.setText(shopBodyFeature);
                ViewExtensionsKt.visible(this.textBodyFeature);
            } else {
                ViewExtensionsKt.gone(this.textBodyFeature);
            }
            String shopProductFeature = feedVariantInfo.getFeed().getShopProductFeature();
            if (shopProductFeature != null) {
                this.textProductFeature.setText(shopProductFeature);
                ViewExtensionsKt.visible(this.textProductFeature);
            } else {
                ViewExtensionsKt.gone(this.textProductFeature);
            }
            updateShopStyle(feedVariantInfo.getFeed().getShopStyles());
            updateFeedState(feedVariantInfo);
            this.shopFavoriteImageView.setOnClickListener(new ShopPreviewFeedHolder$initShopInfoView$3(this, feedVariantInfo));
            this.itemView.setOnClickListener(new ShopPreviewFeedHolder$initShopInfoView$4(this, feedVariantInfo));
            ImageView imageView = this.productLeftImageView;
            List shopPreViews = feedVariantInfo.getFeed().getShopPreViews();
            Product product = null;
            initProductView(imageView, shopPreViews != null ? (Product) CollectionsKt___CollectionsKt.getOrNull(shopPreViews, 0) : null);
            ImageView imageView2 = this.productCenterImageView;
            List shopPreViews2 = feedVariantInfo.getFeed().getShopPreViews();
            initProductView(imageView2, shopPreViews2 != null ? (Product) CollectionsKt___CollectionsKt.getOrNull(shopPreViews2, 1) : null);
            ImageView imageView3 = this.productRightImageView;
            List shopPreViews3 = feedVariantInfo.getFeed().getShopPreViews();
            if (shopPreViews3 != null) {
                product = (Product) CollectionsKt___CollectionsKt.getOrNull(shopPreViews3, 2);
            }
            initProductView(imageView3, product);
        }
    }

    private final void initProductView(ImageView imageView, Product product) {
        if (product == null) {
            ViewExtensionsKt.invisible(imageView);
        } else {
            ImageViewExtensionKt.loadImageAsProductNotAnim(imageView, product.getShopImageUrl());
        }
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
            frameLayout.setOnClickListener(new ShopPreviewFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        ViewExtensionsKt.gone(this.headerArea);
    }

    private final void updateShopStyle(List<Style> list) {
        int size = list.size();
        if (size == 1) {
            ViewExtensionsKt.gone(this.textStyleKeywordFirst);
            ViewExtensionsKt.gone(this.textStyleKeywordSecond);
            this.textStyleKeywordSingle.setText(((Style) list.get(0)).getName());
            ViewExtensionsKt.visible(this.textStyleKeywordSingle);
        } else if (size != 2) {
            ViewExtensionsKt.gone(this.textStyleKeywordFirst);
            ViewExtensionsKt.gone(this.textStyleKeywordSecond);
            ViewExtensionsKt.gone(this.textStyleKeywordSingle);
        } else {
            ViewExtensionsKt.gone(this.textStyleKeywordSingle);
            this.textStyleKeywordFirst.setText(((Style) list.get(0)).getName());
            ViewExtensionsKt.visible(this.textStyleKeywordFirst);
            this.textStyleKeywordSecond.setText(((Style) list.get(1)).getName());
            ViewExtensionsKt.visible(this.textStyleKeywordSecond);
        }
    }

    public final void updateFeedState(@NotNull Feed feed) {
        Intrinsics.checkParameterIsNotNull(feed, MessageTemplateProtocol.TYPE_FEED);
        updateFeedState((FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(feed.getFeeds()));
    }

    private final void updateFeedState(FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo != null) {
            FeedVariant feed = feedVariantInfo.getFeed();
            if (feed != null) {
                ImageView imageView = this.shopFavoriteImageView;
                View view = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
                imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), feed.getShopBookmarkIcon()));
            }
        }
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.shopCoverImageView);
    }
}
