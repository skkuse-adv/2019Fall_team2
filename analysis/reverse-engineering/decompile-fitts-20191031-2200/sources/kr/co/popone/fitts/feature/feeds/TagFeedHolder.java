package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.feature.tag.TagGroup;
import kr.co.popone.fitts.feature.tag.TagGroup.TagView;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TagFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final FrameLayout headerArea;
    private final List<Integer> tagColors = CollectionsKt__CollectionsKt.listOf(Integer.valueOf(C0006R$color.blue2), Integer.valueOf(C0006R$color.navy1), Integer.valueOf(C0006R$color.purple2));
    private final TagGroup tagGroupView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_tag_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TagFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_tag_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new TagFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SessionProvider, SchemeAction {
    }

    public TagFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.headerArea = (FrameLayout) view.findViewById(C0010R$id.layoutHeaderView);
        this.tagGroupView = (TagGroup) view.findViewById(C0010R$id.tagGroupView);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            initView((Feed) t);
        }
    }

    private final void initView(Feed feed) {
        initTitleView(feed);
        int i = 0;
        this.tagGroupView.setTags(new String[0]);
        for (Object next : feed.getFeeds()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String title = ((FeedVariantInfo) next).getFeed().getTitle();
            List<Integer> list = this.tagColors;
            int intValue = ((Number) list.get(i % list.size())).intValue();
            TagGroup tagGroup = this.tagGroupView;
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            TagView tagView = new TagView(view.getContext(), 1, title, intValue);
            this.tagGroupView.addView(tagView);
            i = i2;
        }
        this.tagGroupView.setOnTagClickListener(new TagFeedHolder$initView$2(this, feed));
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
            frameLayout.setOnClickListener(new TagFeedHolder$initTitleView$$inlined$let$lambda$1(titleHeaderView, this, feed));
            return;
        }
        FrameLayout frameLayout2 = this.headerArea;
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "headerArea");
        ViewExtensionsKt.gone(frameLayout2);
    }

    public void clear() {
        this.tagGroupView.setTags(new String[0]);
        this.headerArea.removeAllViews();
    }
}
