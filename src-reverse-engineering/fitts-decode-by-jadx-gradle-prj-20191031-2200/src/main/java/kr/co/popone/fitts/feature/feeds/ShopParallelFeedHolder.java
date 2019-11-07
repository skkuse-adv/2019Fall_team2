package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopParallelFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final RecyclerView recyclerView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_shop_feed_parallel;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShopParallelFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_shop_feed_parallel, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ShopParallelFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.ShopCircleFeedHolder.Delegate, SessionProvider, SchemeAction {
    }

    public ShopParallelFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C0010R$id.recyclerShopParallel);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "itemView.recyclerShopParallel");
        this.recyclerView = recyclerView2;
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
        initShopView(feed);
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
            frameLayout.setOnClickListener(new ShopParallelFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        ViewExtensionsKt.gone(this.headerArea);
    }

    private final void initShopView(Feed feed) {
        this.recyclerView.setAdapter(new ShopParallelFeedAdapter(feed.getFeeds(), this.delegate));
    }

    public void clear() {
        this.recyclerView.setAdapter(null);
    }
}
