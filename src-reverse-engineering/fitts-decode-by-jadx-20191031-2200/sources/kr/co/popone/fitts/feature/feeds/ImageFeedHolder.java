package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerImage;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImageFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final ImageView imageFeedImageView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_image_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_image_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ImageFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SchemeAction, SessionProvider {
    }

    public ImageFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.imageFeedImageView = (ImageView) view.findViewById(C0010R$id.iv_image_feed);
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
        FeedVariantInfo feedVariantInfo = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(feed.getFeeds());
        initView(feedVariantInfo != null ? feedVariantInfo.getFeed() : null);
    }

    private final void initView(ShopBridgeFeed shopBridgeFeed) {
        initTitleView(shopBridgeFeed);
        FeedVariantInfo feedVariantInfo = (FeedVariantInfo) CollectionsKt___CollectionsKt.firstOrNull(shopBridgeFeed.getFeed().getFeeds());
        initView(feedVariantInfo != null ? feedVariantInfo.getFeed() : null);
    }

    private final void initView(FeedVariant feedVariant) {
        String str = "imageFeedImageView";
        if (feedVariant == null || feedVariant.isEmptyImage()) {
            ImageView imageView = this.imageFeedImageView;
            Intrinsics.checkExpressionValueIsNotNull(imageView, str);
            ViewExtensionsKt.gone(imageView);
            return;
        }
        ImageView imageView2 = this.imageFeedImageView;
        Intrinsics.checkExpressionValueIsNotNull(imageView2, str);
        BannerImage image = feedVariant.getImage();
        String url = image != null ? image.getUrl() : null;
        BannerImage image2 = feedVariant.getImage();
        ImageViewExtensionKt.loadImageWithRatio(imageView2, url, image2 != null ? image2.getRatio() : 0.0f);
        this.itemView.setOnClickListener(new ImageFeedHolder$initView$1(this, feedVariant));
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
            frameLayout.setOnClickListener(new ImageFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
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
            frameLayout.setOnClickListener(new ImageFeedHolder$initTitleView$$inlined$let$lambda$2(shopBridgeTitleView, this, shopBridgeFeed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.imageFeedImageView);
        this.headerArea.removeAllViews();
    }
}
