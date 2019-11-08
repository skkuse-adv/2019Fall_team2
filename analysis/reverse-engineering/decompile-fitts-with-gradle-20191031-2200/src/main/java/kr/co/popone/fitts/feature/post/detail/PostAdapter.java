package kr.co.popone.fitts.feature.post.detail;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ablanco.zoomy.Zoomy.Builder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import org.jetbrains.annotations.NotNull;

public final class PostAdapter extends Adapter<ViewHolder> {
    private final Activity activity;
    private final Delegate delegate;

    public interface Delegate {
        @NotNull
        List<Image> getImageList();
    }

    public final class PostImageHolder extends ViewHolder {
        @NotNull
        private final TextView postDescription;
        @NotNull
        private final LinearLayout postDescriptionView;
        @NotNull
        private final ImageView postImage;

        public PostImageHolder(@NotNull PostAdapter postAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.post_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.post_image");
            this.postImage = imageView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.post_image_description_layout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "itemView.post_image_description_layout");
            this.postDescriptionView = linearLayout;
            TextView textView = (TextView) view.findViewById(C0010R$id.post_image_description);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.post_image_description");
            this.postDescription = textView;
        }

        @NotNull
        public final ImageView getPostImage() {
            return this.postImage;
        }

        @NotNull
        public final LinearLayout getPostDescriptionView() {
            return this.postDescriptionView;
        }

        @NotNull
        public final TextView getPostDescription() {
            return this.postDescription;
        }
    }

    public PostAdapter(@NotNull Activity activity2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.activity = activity2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…item_post, parent, false)");
        PostImageHolder postImageHolder = new PostImageHolder(this, inflate);
        new Builder(this.activity).target(postImageHolder.getPostImage()).register();
        return postImageHolder;
    }

    private final Image getItem(int i) {
        return (Image) this.delegate.getImageList().get(i);
    }

    public int getItemCount() {
        return this.delegate.getImageList().size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof PostImageHolder) {
            Image item = getItem(i);
            BaseRequestOptions placeholder = new RequestOptions().placeholder((Drawable) new ColorDrawable(Color.parseColor(item.getDominantColor())));
            Intrinsics.checkExpressionValueIsNotNull(placeholder, "RequestOptions().placeho…rentItem.dominantColor)))");
            PostImageHolder postImageHolder = (PostImageHolder) viewHolder;
            Glide.with(this.activity).load(item.getThumbnail()).thumbnail(Glide.with(this.activity).load(item.getLqip())).apply((BaseRequestOptions<?>) (RequestOptions) placeholder).into(postImageHolder.getPostImage());
            String description = item.getDescription();
            if (description == null || description.length() == 0) {
                postImageHolder.getPostDescriptionView().setVisibility(8);
                return;
            }
            postImageHolder.getPostDescription().setText(item.getDescription());
            postImageHolder.getPostDescriptionView().setVisibility(0);
        }
    }
}
