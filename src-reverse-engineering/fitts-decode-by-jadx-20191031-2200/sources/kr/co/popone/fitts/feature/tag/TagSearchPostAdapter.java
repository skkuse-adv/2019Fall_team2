package kr.co.popone.fitts.feature.tag;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

public final class TagSearchPostAdapter extends Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public interface Delegate {
        @NotNull
        List<Post> getTagPosts();

        void onCoverImageClick(@NotNull Post post, @NotNull View view);
    }

    public final class TagSearchViewHoldler extends ViewHolder {
        final /* synthetic */ TagSearchPostAdapter this$0;

        public TagSearchViewHoldler(@NotNull TagSearchPostAdapter tagSearchPostAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = tagSearchPostAdapter;
            super(view);
        }

        public final void bind(@NotNull Post post) {
            Intrinsics.checkParameterIsNotNull(post, "post");
            View view = this.itemView;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.ivBigPostFittie);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
            ImageViewExtensionKt.loadImageAsProfile(circleImageView, post.getUser().getProfileImageUrl());
            RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.ivBigPostCover);
            Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
            Image coverImage = post.getCoverImage();
            String str = null;
            String thumbnail = coverImage != null ? coverImage.getThumbnail() : null;
            Image coverImage2 = post.getCoverImage();
            if (coverImage2 != null) {
                str = coverImage2.getDominantColor();
            }
            ImageViewExtensionKt.loadImageAsPost(roundImageView, thumbnail, str);
            TextView textView = (TextView) view.findViewById(C0010R$id.tvPostTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvPostTitle");
            textView.setText(post.getTitle());
            TextView textView2 = (TextView) view.findViewById(C0010R$id.tvBigPostFittie);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
            textView2.setText(post.getUser().getFittsID());
            view.setOnClickListener(new TagSearchPostAdapter$TagSearchViewHoldler$bind$$inlined$with$lambda$1(post, view, this, post));
            View findViewById = view.findViewById(C0010R$id.viewFittieBlueDot);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewFittieBlueDot");
            findViewById.setVisibility(post.getUser().isSuitable() ? 0 : 8);
        }
    }

    public TagSearchPostAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_square, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…st_square, parent, false)");
        return new TagSearchViewHoldler(this, inflate);
    }

    private final Post getItem(int i) {
        return (Post) this.delegate.getTagPosts().get(i);
    }

    public int getItemCount() {
        return this.delegate.getTagPosts().size();
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof TagSearchViewHoldler) {
            ((TagSearchViewHoldler) viewHolder).bind(getItem(i));
        }
    }
}
