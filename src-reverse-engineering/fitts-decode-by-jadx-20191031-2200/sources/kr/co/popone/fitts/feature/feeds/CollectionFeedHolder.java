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
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerImage;
import kr.co.popone.fitts.model.datamodel.social.feed.CollectionFeedView;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollectionFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    private final CollectionFeedView center;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final CollectionFeedView left;
    private final CollectionFeedView right;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_collection_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CollectionFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_collection_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new CollectionFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, SchemeAction {
    }

    public CollectionFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.ivCollectionLeft);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "itemView.ivCollectionLeft");
        TextView textView = (TextView) view.findViewById(C0010R$id.tvCollectionTitleLeft);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.tvCollectionTitleLeft");
        Group group = (Group) view.findViewById(C0010R$id.grTitleLeft);
        Intrinsics.checkExpressionValueIsNotNull(group, "itemView.grTitleLeft");
        this.left = new CollectionFeedView(roundImageView, textView, group);
        RoundImageView roundImageView2 = (RoundImageView) view.findViewById(C0010R$id.ivCollectionCenter);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView2, "itemView.ivCollectionCenter");
        TextView textView2 = (TextView) view.findViewById(C0010R$id.tvCollectionTitleCenter);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.tvCollectionTitleCenter");
        Group group2 = (Group) view.findViewById(C0010R$id.grTitleCenter);
        Intrinsics.checkExpressionValueIsNotNull(group2, "itemView.grTitleCenter");
        this.center = new CollectionFeedView(roundImageView2, textView2, group2);
        RoundImageView roundImageView3 = (RoundImageView) view.findViewById(C0010R$id.ivCollectionRight);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView3, "itemView.ivCollectionRight");
        TextView textView3 = (TextView) view.findViewById(C0010R$id.tvCollectionTitleRight);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.tvCollectionTitleRight");
        Group group3 = (Group) view.findViewById(C0010R$id.grTitleRight);
        Intrinsics.checkExpressionValueIsNotNull(group3, "itemView.grTitleRight");
        this.right = new CollectionFeedView(roundImageView3, textView3, group3);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        initView(this.left, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        initView(this.center, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
        initView(this.right, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 2));
    }

    private final void initView(CollectionFeedView collectionFeedView, FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo == null || feedVariantInfo.getFeed().isEmptyImage()) {
            ViewExtensionsKt.gone(collectionFeedView.getImageView());
            ViewExtensionsKt.gone(collectionFeedView.getTitleGroup());
            return;
        }
        ImageView imageView = collectionFeedView.getImageView();
        BannerImage image = feedVariantInfo.getFeed().getImage();
        ImageViewExtensionKt.loadImageAsProductNotAnim(imageView, image != null ? image.getUrl() : null);
        imageView.setOnClickListener(new CollectionFeedHolder$initView$$inlined$with$lambda$1(this, feedVariantInfo));
        ViewExtensionsKt.visible(imageView);
        String title = feedVariantInfo.getFeed().getTitle();
        if (title != null) {
            collectionFeedView.getTitleView().setText(title);
            ViewExtensionsKt.visible(collectionFeedView.getTitleGroup());
            return;
        }
        ViewExtensionsKt.gone(collectionFeedView.getTitleGroup());
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
            frameLayout.setOnClickListener(new CollectionFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        clear(this.left);
        clear(this.center);
        clear(this.right);
        this.headerArea.removeAllViews();
    }

    private final void clear(CollectionFeedView collectionFeedView) {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) collectionFeedView.getImageView());
        collectionFeedView.getTitleView().setText(null);
    }
}
