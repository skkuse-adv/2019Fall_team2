package kr.co.popone.fitts.feature.feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final CircleImageView fittieProfileImageView;
    private final View fittieSuitBlueViwe;
    private final RoundImageView postCoverImageView;
    private final TextView postFittieIdTextView;
    private final TextView postTitleTextView;

    public interface Delegate {
        void onPostFeedClick(long j, @Nullable String str);
    }

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_post_square;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_square, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new PostFeedHolder(inflate, delegate);
        }
    }

    public PostFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.postCoverImageView = (RoundImageView) view.findViewById(C0010R$id.ivBigPostCover);
        this.fittieProfileImageView = (CircleImageView) view.findViewById(C0010R$id.ivBigPostFittie);
        this.postTitleTextView = (TextView) view.findViewById(C0010R$id.tvPostTitle);
        this.postFittieIdTextView = (TextView) view.findViewById(C0010R$id.tvBigPostFittie);
        this.fittieSuitBlueViwe = view.findViewById(C0010R$id.viewFittieBlueDot);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Post) {
            updatePostFeedHolderUi((Post) t);
        }
    }

    public void clear() {
        View view = this.itemView;
        String str = "itemView";
        Intrinsics.checkExpressionValueIsNotNull(view, str);
        Glide.with(view.getContext()).clear((View) this.postCoverImageView);
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, str);
        Glide.with(view2.getContext()).clear((View) this.fittieProfileImageView);
    }

    private final void updatePostFeedHolderUi(Post post) {
        RoundImageView roundImageView = this.postCoverImageView;
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "postCoverImageView");
        Image coverImage = post.getCoverImage();
        String str = null;
        String url = coverImage != null ? coverImage.getUrl() : null;
        Image coverImage2 = post.getCoverImage();
        if (coverImage2 != null) {
            str = coverImage2.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
        CircleImageView circleImageView = this.fittieProfileImageView;
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "fittieProfileImageView");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, post.getUser().getProfileImageUrl());
        TextView textView = this.postTitleTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "postTitleTextView");
        textView.setText(post.getTitle());
        TextView textView2 = this.postFittieIdTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "postFittieIdTextView");
        textView2.setText(post.getUser().getFittsID());
        String str2 = "fittieSuitBlueViwe";
        if (post.getUser().isSuitable()) {
            View view = this.fittieSuitBlueViwe;
            Intrinsics.checkExpressionValueIsNotNull(view, str2);
            ViewExtensionsKt.visible(view);
        } else {
            View view2 = this.fittieSuitBlueViwe;
            Intrinsics.checkExpressionValueIsNotNull(view2, str2);
            ViewExtensionsKt.gone(view2);
        }
        this.itemView.setOnClickListener(new PostFeedHolder$updatePostFeedHolderUi$$inlined$run$lambda$1(post, this));
    }
}
