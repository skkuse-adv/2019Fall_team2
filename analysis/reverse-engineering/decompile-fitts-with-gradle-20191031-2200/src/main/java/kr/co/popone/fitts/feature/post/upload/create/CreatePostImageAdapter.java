package kr.co.popone.fitts.feature.post.upload.create;

import android.content.Context;
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
import com.bumptech.glide.Glide;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.joooonho.SelectableRoundedImageView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostDetailImage;
import kr.co.popone.fitts.ui.ViewExtensions;
import org.jetbrains.annotations.NotNull;

public final class CreatePostImageAdapter extends Adapter<ViewHolder> {
    private final Context context;
    @NotNull
    private final Delegate delegate;
    @NotNull
    private ArrayList<PostDetailImage> images = new ArrayList<>();

    public static final class CreatePostImageDecorator extends ItemDecoration {
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(rect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            super.getItemOffsets(rect, view, recyclerView, state);
            ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
            Context context = view.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            int dpToPx = viewExtensions.dpToPx(context, 5);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition != -1) {
                int itemCount = state.getItemCount();
                if (childAdapterPosition == 0) {
                    rect.set(0, 0, dpToPx, 0);
                } else if (itemCount <= 0 || childAdapterPosition != itemCount - 1) {
                    rect.set(dpToPx, 0, dpToPx, 0);
                } else {
                    rect.set(dpToPx, 0, 0, 0);
                }
            }
        }
    }

    public interface Delegate {
        void onImageClick();
    }

    public final class ItemViewHolder extends ViewHolder {
        @NotNull
        private final ImageView selectedPhoto;

        public ItemViewHolder(@NotNull CreatePostImageAdapter createPostImageAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            SelectableRoundedImageView selectableRoundedImageView = (SelectableRoundedImageView) view.findViewById(C0010R$id.selected_photo);
            Intrinsics.checkExpressionValueIsNotNull(selectableRoundedImageView, "itemView.selected_photo");
            this.selectedPhoto = selectableRoundedImageView;
        }

        @NotNull
        public final ImageView getSelectedPhoto() {
            return this.selectedPhoto;
        }
    }

    public CreatePostImageAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final ArrayList<PostDetailImage> getImages() {
        return this.images;
    }

    public final void setImages(@NotNull ArrayList<PostDetailImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.images = arrayList;
    }

    public final void add(@NotNull PostDetailImage postDetailImage) {
        Intrinsics.checkParameterIsNotNull(postDetailImage, MessengerShareContentUtility.MEDIA_IMAGE);
        this.images.add(postDetailImage);
        notifyDataSetChanged();
    }

    public final void addAll(@NotNull ArrayList<PostDetailImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "images");
        this.images = arrayList;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_create_post_image, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "v");
        return new ItemViewHolder(this, inflate);
    }

    private final PostDetailImage getItem(int i) {
        Object obj = this.images.get(i);
        Intrinsics.checkExpressionValueIsNotNull(obj, "images.get(position)");
        return (PostDetailImage) obj;
    }

    public int getItemCount() {
        return this.images.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        String detailImagePath = getItem(i).getDetailImagePath();
        if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            Glide.with(this.context).load(detailImagePath).into(itemViewHolder.getSelectedPhoto());
            itemViewHolder.getSelectedPhoto().setOnClickListener(new CreatePostImageAdapter$onBindViewHolder$1(this));
        }
    }
}
