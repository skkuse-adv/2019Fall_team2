package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.FittieAction;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittieFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final View fittieCenter;
    private final View fittieLeft;
    private final View fittieRight;
    private final FrameLayout headerArea;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_feed_fittie;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_feed_fittie, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, FittieAction, SchemeAction {
    }

    public FittieFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.fittieLeft = view.findViewById(C0010R$id.viewFittieLeft);
        this.fittieCenter = view.findViewById(C0010R$id.viewFittieCenter);
        this.fittieRight = view.findViewById(C0010R$id.viewFittieRight);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        View view = this.fittieLeft;
        Intrinsics.checkExpressionValueIsNotNull(view, "fittieLeft");
        initView(view, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 0));
        View view2 = this.fittieCenter;
        Intrinsics.checkExpressionValueIsNotNull(view2, "fittieCenter");
        initView(view2, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 1));
        View view3 = this.fittieRight;
        Intrinsics.checkExpressionValueIsNotNull(view3, "fittieRight");
        initView(view3, (FeedVariantInfo) CollectionsKt___CollectionsKt.getOrNull(feed.getFeeds(), 2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        if (r0 != null) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView(android.view.View r4, kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x0081
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r0 = r5.getFeed()
            boolean r0 = r0.isEmptyFittie()
            if (r0 == 0) goto L_0x000e
            goto L_0x0081
        L_0x000e:
            int r0 = kr.co.popone.fitts.C0010R$id.iv_fittie_profile
            android.view.View r0 = r4.findViewById(r0)
            de.hdodenhof.circleimageview.CircleImageView r0 = (de.hdodenhof.circleimageview.CircleImageView) r0
            java.lang.String r1 = "view.iv_fittie_profile"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r1 = r5.getFeed()
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r1.getUser()
            r2 = 0
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r1.getProfileImageUrl()
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            kr.co.popone.fitts.ui.ImageViewExtensionKt.loadImageAsProfile(r0, r1)
            int r0 = kr.co.popone.fitts.C0010R$id.tv_fitts_id
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "view.tv_fitts_id"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r1 = r5.getFeed()
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r1.getUser()
            if (r1 == 0) goto L_0x004a
            java.lang.String r2 = r1.getFittsID()
        L_0x004a:
            r0.setText(r2)
            int r0 = kr.co.popone.fitts.C0010R$id.tv_user_type
            android.view.View r4 = r4.findViewById(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r0 = "view.tv_user_type"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant r0 = r5.getFeed()
            kr.co.popone.fitts.model.datamodel.service.user.User r0 = r0.getUser()
            if (r0 == 0) goto L_0x0071
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = r0.toSimpleInfo()
            if (r0 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            java.lang.String r0 = ""
        L_0x0073:
            r4.setText(r0)
            android.view.View r4 = r3.itemView
            kr.co.popone.fitts.feature.feeds.FittieFeedHolder$initView$1 r0 = new kr.co.popone.fitts.feature.feeds.FittieFeedHolder$initView$1
            r0.<init>(r3, r5)
            r4.setOnClickListener(r0)
            return
        L_0x0081:
            kr.co.popone.fitts.ui.ViewExtensionsKt.invisible(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.feeds.FittieFeedHolder.initView(android.view.View, kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo):void");
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
            frameLayout.setOnClickListener(new FittieFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        View view = this.fittieLeft;
        Intrinsics.checkExpressionValueIsNotNull(view, "fittieLeft");
        clearView(view);
        View view2 = this.fittieCenter;
        Intrinsics.checkExpressionValueIsNotNull(view2, "fittieCenter");
        clearView(view2);
        View view3 = this.fittieRight;
        Intrinsics.checkExpressionValueIsNotNull(view3, "fittieRight");
        clearView(view3);
        this.headerArea.removeAllViews();
    }

    private final void clearView(View view) {
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
        Glide.with(view2.getContext()).clear((View) (CircleImageView) view.findViewById(C0010R$id.iv_fittie_profile));
        TextView textView = (TextView) view.findViewById(C0010R$id.tv_fitts_id);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view.tv_fitts_id");
        textView.setText(null);
        TextView textView2 = (TextView) view.findViewById(C0010R$id.tv_user_type);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "view.tv_user_type");
        textView2.setText(null);
    }
}
