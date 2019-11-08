package kr.co.popone.fitts.feature.collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

public final class PostsTypeAdapter extends Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public final int columns;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final ArrayList<Post> items = new ArrayList<>();

    public interface Delegate {
        void onPostClicked(@NotNull Post post);
    }

    public final class PostsTypeViewHolder extends ViewHolder {
        final /* synthetic */ PostsTypeAdapter this$0;

        public PostsTypeViewHolder(@NotNull PostsTypeAdapter postsTypeAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = postsTypeAdapter;
            super(view);
        }

        public final void init(@NotNull Post post) {
            Intrinsics.checkParameterIsNotNull(post, "post");
            View view = this.itemView;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.ivBigPostFittie);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
            ImageViewExtensionKt.loadImageAsProfile(circleImageView, post.getUser().getProfileImageUrl());
            RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.ivBigPostCover);
            Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
            Image coverImage = post.getCoverImage();
            String str = null;
            String url = coverImage != null ? coverImage.getUrl() : null;
            Image coverImage2 = post.getCoverImage();
            if (coverImage2 != null) {
                str = coverImage2.getDominantColor();
            }
            ImageViewExtensionKt.loadImageAsPost(roundImageView, url, str);
            TextView textView = (TextView) view.findViewById(C0010R$id.tvPostTitle);
            String str2 = "tvPostTitle";
            Intrinsics.checkExpressionValueIsNotNull(textView, str2);
            textView.setText(post.getTitle());
            TextView textView2 = (TextView) view.findViewById(C0010R$id.tvBigPostFittie);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
            textView2.setText(post.getUser().getFittsID());
            view.setOnClickListener(new PostsTypeAdapter$PostsTypeViewHolder$init$$inlined$with$lambda$1(view, this, post));
            View findViewById = view.findViewById(C0010R$id.viewFittieBlueDot);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewFittieBlueDot");
            findViewById.setVisibility(post.getUser().isSuitable() ? 0 : 8);
            if (this.this$0.columns == 3) {
                TextView textView3 = (TextView) view.findViewById(C0010R$id.tvPostTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
                ViewExtensionsKt.gone(textView3);
                return;
            }
            TextView textView4 = (TextView) view.findViewById(C0010R$id.tvPostTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
            ViewExtensionsKt.visible(textView4);
        }
    }

    public PostsTypeAdapter(int i, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.columns = i;
        this.delegate = delegate2;
    }

    public final void addAll(@NotNull ArrayList<Post> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "items");
        if (!this.items.isEmpty()) {
            this.items.clear();
        }
        this.items.addAll(arrayList);
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_square, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new PostsTypeViewHolder(this, inflate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof PostsTypeViewHolder) {
            PostsTypeViewHolder postsTypeViewHolder = (PostsTypeViewHolder) viewHolder;
            Object obj = this.items.get(i);
            Intrinsics.checkExpressionValueIsNotNull(obj, "items[position]");
            postsTypeViewHolder.init((Post) obj);
        }
    }
}
