package kr.co.popone.fitts.feature.recommend.personalization;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class PersonalizedRecommendUserPostAdapter extends Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Decoration extends ItemDecoration {
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(rect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            rect.left = ViewExtensionsKt.dpToPx(view, 3);
            rect.right = ViewExtensionsKt.dpToPx(view, 3);
            rect.bottom = ViewExtensionsKt.dpToPx(view, 28);
        }
    }

    public interface Delegate {
        @NotNull
        List<Post> getPosts();

        void onPostContentClicked(@NotNull Post post, @NotNull View view);
    }

    public static final class RecommendUserSubHolder extends ViewHolder {
        @NotNull
        private final ImageView coverImageView;

        public RecommendUserSubHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.coverImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.coverImageView)");
            this.coverImageView = (ImageView) findViewById;
        }

        @NotNull
        public final ImageView getCoverImageView() {
            return this.coverImageView;
        }
    }

    public PersonalizedRecommendUserPostAdapter(@NotNull Activity activity, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recommended_user_sub, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new RecommendUserSubHolder(inflate);
    }

    public int getItemCount() {
        return this.delegate.getPosts().size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof RecommendUserSubHolder) {
            Post post = (Post) this.delegate.getPosts().get(i);
            RecommendUserSubHolder recommendUserSubHolder = (RecommendUserSubHolder) viewHolder;
            ImageView coverImageView = recommendUserSubHolder.getCoverImageView();
            Image coverImage = post.getCoverImage();
            String str = null;
            String url = coverImage != null ? coverImage.getUrl() : null;
            Image coverImage2 = post.getCoverImage();
            if (coverImage2 != null) {
                str = coverImage2.getDominantColor();
            }
            ImageViewExtensionKt.loadImage(coverImageView, url, str);
            recommendUserSubHolder.itemView.setOnClickListener(new PersonalizedRecommendUserPostAdapter$onBindViewHolder$$inlined$let$lambda$1(recommendUserSubHolder, post, this, viewHolder));
        }
    }
}
