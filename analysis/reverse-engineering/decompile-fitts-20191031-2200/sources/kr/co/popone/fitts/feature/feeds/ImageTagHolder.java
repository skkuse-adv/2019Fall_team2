package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImageTagHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final View imageTagFirstView;
    private final View imageTagFourthView;
    private final View imageTagSecondView;
    private final View imageTagThirdView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_tag_square_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageTagHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_tag_square_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ImageTagHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SchemeAction, SessionProvider {
        void onImageTagClick(long j);
    }

    public void clear() {
    }

    public ImageTagHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.imageTagFirstView = view.findViewById(C0010R$id.viewFirst);
        this.imageTagSecondView = view.findViewById(C0010R$id.viewSecond);
        this.imageTagThirdView = view.findViewById(C0010R$id.viewThird);
        this.imageTagFourthView = view.findViewById(C0010R$id.viewFourth);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        View view = this.imageTagFirstView;
        Intrinsics.checkExpressionValueIsNotNull(view, "imageTagFirstView");
        initView(view, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        View view2 = this.imageTagSecondView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "imageTagSecondView");
        initView(view2, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
        View view3 = this.imageTagThirdView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "imageTagThirdView");
        initView(view3, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 2));
        View view4 = this.imageTagFourthView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "imageTagFourthView");
        initView(view4, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 3));
    }

    private final void initView(View view, FeedVariantInfo feedVariantInfo) {
        if (feedVariantInfo == null || feedVariantInfo.getFeed().isEmptyImageTag()) {
            ViewExtensionsKt.invisible(view);
            return;
        }
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.ivTagCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "view.ivTagCover");
        ImageViewExtensionKt.loadImageAsProductNotAnim(roundImageView, feedVariantInfo.getFeed().getImageUrl());
        TextView textView = (TextView) view.findViewById(C0010R$id.tvTagName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view.tvTagName");
        textView.setText(feedVariantInfo.getFeed().getTitle());
        view.setOnClickListener(new ImageTagHolder$initView$1(this, feedVariantInfo));
        ViewExtensionsKt.visible(view);
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
            frameLayout.setOnClickListener(new ImageTagHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }
}
