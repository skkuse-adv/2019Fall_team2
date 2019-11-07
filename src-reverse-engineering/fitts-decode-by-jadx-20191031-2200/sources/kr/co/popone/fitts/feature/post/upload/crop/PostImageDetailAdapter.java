package kr.co.popone.fitts.feature.post.upload.crop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import org.jetbrains.annotations.NotNull;

public final class PostImageDetailAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_ITEM = 1;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener imageCropButtonListener = new PostImageDetailAdapter$imageCropButtonListener$1(this);
    private final OnClickListener imageInsertButtonListener = new PostImageDetailAdapter$imageInsertButtonListener$1(this);
    private final OnClickListener imageRemoveButtonListener = new PostImageDetailAdapter$imageRemoveButtonListener$1(this);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate {
        @NotNull
        ArrayList<CreatePostImage> getPostImages();

        boolean isModifyData();

        void onAddImageClick();

        void onCropClick(@NotNull CreatePostImage createPostImage, int i);

        void onRemoveClick(@NotNull CreatePostImage createPostImage, int i);
    }

    public static final class FooterViewHolder extends ViewHolder {
        @NotNull
        private final LinearLayout imageInsertButton;
        @NotNull
        private final TextView photoPlus;

        public FooterViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.image_insert_button);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "itemView.image_insert_button");
            this.imageInsertButton = linearLayout;
            TextView textView = (TextView) view.findViewById(C0010R$id.photo_plus);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.photo_plus");
            this.photoPlus = textView;
        }

        @NotNull
        public final LinearLayout getImageInsertButton() {
            return this.imageInsertButton;
        }

        @NotNull
        public final TextView getPhotoPlus() {
            return this.photoPlus;
        }
    }

    public static final class ItemViewHolder extends ViewHolder {
        private int itemPosition;
        @NotNull
        private final ImageView postImage;
        @NotNull
        private final ImageButton postImageCropButton;
        @NotNull
        private final EditText postImageDescription;
        @NotNull
        private final ImageButton postImageRemoveButton;

        public ItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.post_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.post_image");
            this.postImage = imageView;
            ImageButton imageButton = (ImageButton) view.findViewById(C0010R$id.post_image_remove_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "itemView.post_image_remove_button");
            this.postImageRemoveButton = imageButton;
            ImageButton imageButton2 = (ImageButton) view.findViewById(C0010R$id.post_image_crop_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton2, "itemView.post_image_crop_button");
            this.postImageCropButton = imageButton2;
            EditText editText = (EditText) view.findViewById(C0010R$id.post_image_description);
            Intrinsics.checkExpressionValueIsNotNull(editText, "itemView.post_image_description");
            this.postImageDescription = editText;
        }

        @NotNull
        public final ImageView getPostImage() {
            return this.postImage;
        }

        @NotNull
        public final ImageButton getPostImageRemoveButton() {
            return this.postImageRemoveButton;
        }

        @NotNull
        public final ImageButton getPostImageCropButton() {
            return this.postImageCropButton;
        }

        @NotNull
        public final EditText getPostImageDescription() {
            return this.postImageDescription;
        }

        public final int getItemPosition() {
            return this.itemPosition;
        }

        public final void setItemPosition(int i) {
            this.itemPosition = i;
        }
    }

    public PostImageDetailAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "v";
        if (i == TYPE_FOOTER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_postwrite_footer, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            FooterViewHolder footerViewHolder = new FooterViewHolder(inflate);
            footerViewHolder.getImageInsertButton().setOnClickListener(this.imageInsertButtonListener);
            return footerViewHolder;
        } else if (i == TYPE_ITEM) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_postwritedetail, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            ItemViewHolder itemViewHolder = new ItemViewHolder(inflate2);
            itemViewHolder.getPostImageRemoveButton().setOnClickListener(this.imageRemoveButtonListener);
            itemViewHolder.getPostImageCropButton().setOnClickListener(this.imageCropButtonListener);
            itemViewHolder.getPostImageDescription().addTextChangedListener(new PostImageDetailAdapter$onCreateViewHolder$1(this, itemViewHolder));
            return itemViewHolder;
        } else {
            throw new IllegalAccessException();
        }
    }

    private final CreatePostImage getItem(int i) {
        Object obj = this.delegate.getPostImages().get(i);
        Intrinsics.checkExpressionValueIsNotNull(obj, "delegate.postImages[position]");
        return (CreatePostImage) obj;
    }

    public int getItemViewType(int i) {
        if (i == this.delegate.getPostImages().size()) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    public int getItemCount() {
        return this.delegate.getPostImages().size() + 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof FooterViewHolder) {
            if (this.delegate.isModifyData()) {
                ((FooterViewHolder) viewHolder).getPhotoPlus().setText("사진 추가");
            } else {
                ((FooterViewHolder) viewHolder).getPhotoPlus().setText("사진 변경 및 추가");
            }
        } else if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.setItemPosition(i);
            itemViewHolder.getPostImageRemoveButton().setTag(Integer.valueOf(i));
            itemViewHolder.getPostImageCropButton().setTag(Integer.valueOf(i));
            CreatePostImage item = getItem(i);
            Glide.with(this.context).load(item.getPath()).into(itemViewHolder.getPostImage());
            if (item.getId() == null) {
                itemViewHolder.getPostImageCropButton().setVisibility(0);
            } else {
                itemViewHolder.getPostImageCropButton().setVisibility(8);
            }
            itemViewHolder.getPostImageDescription().setText(item.getDescription(), BufferType.EDITABLE);
        }
    }
}
