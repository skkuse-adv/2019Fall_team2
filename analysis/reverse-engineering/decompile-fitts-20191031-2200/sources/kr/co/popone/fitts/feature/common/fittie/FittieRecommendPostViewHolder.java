package kr.co.popone.fitts.feature.common.fittie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendPostViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FittieRecommendPostViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recommended_user_sub, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new FittieRecommendPostViewHolder(inflate);
        }
    }

    public FittieRecommendPostViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull Post post) {
        Intrinsics.checkParameterIsNotNull(post, "post");
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(C0010R$id.coverImageView);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "coverImageView");
        Image coverImage = post.getCoverImage();
        String str = null;
        String thumbnail = coverImage != null ? coverImage.getThumbnail() : null;
        Image coverImage2 = post.getCoverImage();
        if (coverImage2 != null) {
            str = coverImage2.getDominantColor();
        }
        ImageViewExtensionKt.loadImageAsPost(roundImageView, thumbnail, str);
    }

    public final void clear() {
        View view = this.itemView;
        Glide.with(view.getContext()).clear((View) (RoundImageView) view.findViewById(C0010R$id.coverImageView));
    }
}
