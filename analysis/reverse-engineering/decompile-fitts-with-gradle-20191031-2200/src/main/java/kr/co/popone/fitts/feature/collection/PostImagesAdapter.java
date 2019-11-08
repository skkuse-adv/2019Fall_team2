package kr.co.popone.fitts.feature.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.annotations.NotNull;

public final class PostImagesAdapter extends Adapter<PostImageItemViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener imageClickListener = new PostImagesAdapter$imageClickListener$1(this);
    @NotNull
    private List<String> postImages = CollectionsKt__CollectionsKt.emptyList();
    private int postPosition;

    public interface Delegate {
        void onShowPost(int i);
    }

    public static final class PostImageItemViewHolder extends ViewHolder {
        @NotNull
        private final ImageView imageView;

        public PostImageItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.imageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.imageView)");
            this.imageView = (ImageView) findViewById;
        }

        @NotNull
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    public PostImagesAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public final List<String> getPostImages() {
        return this.postImages;
    }

    public final void setPostImages(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.postImages = list;
        notifyDataSetChanged();
    }

    public final int getPostPosition() {
        return this.postPosition;
    }

    public final void setPostPosition(int i) {
        this.postPosition = i;
    }

    public int getItemCount() {
        return this.postImages.size();
    }

    @NotNull
    public PostImageItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_collection_multi_post, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        PostImageItemViewHolder postImageItemViewHolder = new PostImageItemViewHolder(inflate);
        postImageItemViewHolder.itemView.setOnClickListener(this.imageClickListener);
        return postImageItemViewHolder;
    }

    public void onBindViewHolder(@NotNull PostImageItemViewHolder postImageItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(postImageItemViewHolder, "holder");
        ImageViewExtensionKt.loadImage$default(postImageItemViewHolder.getImageView(), (String) this.postImages.get(i), null, 2, null);
    }
}
