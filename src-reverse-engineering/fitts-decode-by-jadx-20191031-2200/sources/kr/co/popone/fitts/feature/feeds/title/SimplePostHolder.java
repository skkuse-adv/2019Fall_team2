package kr.co.popone.fitts.feature.feeds.title;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.action.PostAction;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;
import kr.co.popone.fitts.model.post.PostFeedViewData;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimplePostHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final RoundImageView postCoverImageView;

    public interface Delegate extends PostAction {
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_simple_post;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SimplePostHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_simple_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SimplePostHolder(inflate, delegate);
        }
    }

    public SimplePostHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.postCoverImageView = (RoundImageView) view.findViewById(C0010R$id.ivPostCover);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof CategoryPostItem) {
            initView((CategoryPostItem) t);
        } else if (t instanceof PostFeedViewData) {
            initView((PostFeedViewData) t);
        } else if (t instanceof PostSearchResult) {
            initView((PostSearchResult) t);
        }
    }

    private final void initView(CategoryPostItem categoryPostItem) {
        RoundImageView roundImageView = this.postCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "postCoverImageView");
        Image coverImage = categoryPostItem.getPost().getCoverImage();
        String str = null;
        String url = coverImage != null ? coverImage.getUrl() : null;
        Image coverImage2 = categoryPostItem.getPost().getCoverImage();
        if (coverImage2 != null) {
            str = coverImage2.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
        this.itemView.setOnClickListener(new SimplePostHolder$initView$1(this, categoryPostItem));
    }

    private final void initView(PostFeedViewData postFeedViewData) {
        RoundImageView roundImageView = this.postCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "postCoverImageView");
        ImageViewExtensionKt.loadImageAsPost(roundImageView, postFeedViewData.getCoverUrl(), postFeedViewData.getDominantColor());
        this.itemView.setOnClickListener(new SimplePostHolder$initView$2(this, postFeedViewData));
    }

    private final void initView(PostSearchResult postSearchResult) {
        RoundImageView roundImageView = this.postCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "postCoverImageView");
        Image coverImage = postSearchResult.getPost().getCoverImage();
        String str = null;
        String url = coverImage != null ? coverImage.getUrl() : null;
        Image coverImage2 = postSearchResult.getPost().getCoverImage();
        if (coverImage2 != null) {
            str = coverImage2.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
        this.itemView.setOnClickListener(new SimplePostHolder$initView$3(this, postSearchResult));
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.postCoverImageView);
    }
}
