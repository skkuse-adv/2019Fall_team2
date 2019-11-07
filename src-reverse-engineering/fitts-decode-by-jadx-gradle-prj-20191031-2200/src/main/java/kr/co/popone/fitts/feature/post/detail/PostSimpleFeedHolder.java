package kr.co.popone.fitts.feature.post.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostSimpleFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final RoundImageView simplePostImageView;

    public interface Delegate {
        void onSimplePostClick(long j);
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_post_simple_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostSimpleFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_simple_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new PostSimpleFeedHolder(inflate, delegate);
        }
    }

    public PostSimpleFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.simplePostImageView = (RoundImageView) view.findViewById(C0010R$id.iv_simple_post);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Post) {
            updatePostSimpleUi((Post) t);
        } else if (t instanceof PostSearchResult) {
            updatePostSimpleUi(((PostSearchResult) t).getPost());
        }
    }

    private final void updatePostSimpleUi(Post post) {
        RoundImageView roundImageView = this.simplePostImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "simplePostImageView");
        Image coverImage = post.getCoverImage();
        String str = null;
        String url = coverImage != null ? coverImage.getUrl() : null;
        Image coverImage2 = post.getCoverImage();
        if (coverImage2 != null) {
            str = coverImage2.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
        this.itemView.setOnClickListener(new PostSimpleFeedHolder$updatePostSimpleUi$1(this, post));
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.simplePostImageView);
    }
}
