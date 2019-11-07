package kr.co.popone.fitts.feature.me.like;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LikedPostViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LikedPostViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_square, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new LikedPostViewHolder(inflate);
        }
    }

    public interface Delegate {
        void onPostClicked(long j, @Nullable String str);
    }

    public LikedPostViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bind(@NotNull Post post, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(post, "post");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        View view = this.itemView;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.ivBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
        ImageViewExtensionKt.loadImageAsProfile(circleImageView, post.getUser().getProfileImageUrl());
        RequestManager with = Glide.with(view.getContext());
        Image coverImage = post.getCoverImage();
        String str = null;
        RequestBuilder load = with.load(coverImage != null ? coverImage.getUrl() : null);
        RequestManager with2 = Glide.with(view.getContext());
        Image coverImage2 = post.getCoverImage();
        load.thumbnail(with2.load(coverImage2 != null ? coverImage2.getThumbnail() : null)).into((ImageView) (RoundImageView) view.findViewById(C0010R$id.ivBigPostCover));
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.ivBigPostCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
        Image coverImage3 = post.getCoverImage();
        String url = coverImage3 != null ? coverImage3.getUrl() : null;
        Image coverImage4 = post.getCoverImage();
        if (coverImage4 != null) {
            str = coverImage4.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
        TextView textView = (TextView) view.findViewById(C0010R$id.tvPostTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvPostTitle");
        textView.setText(post.getTitle());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.tvBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
        textView2.setText(post.getUser().getFittsID());
        view.setOnClickListener(new LikedPostViewHolder$bind$$inlined$with$lambda$1(post, view, post, delegate));
        View findViewById = view.findViewById(C0010R$id.viewFittieBlueDot);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewFittieBlueDot");
        findViewById.setVisibility(post.getUser().isSuitable() ? 0 : 8);
    }
}
