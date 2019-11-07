package photopicker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.model.LocalMedia;
import photopicker.view.ImageSelectorActivity;

public final class ImageListAdapter extends Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public OnImageSelectChangedListener imageSelectChangedListener;
    @NotNull
    private List<LocalMedia> images = new ArrayList();
    private ArrayList<LocalMedia> selectImages = new ArrayList<>();
    /* access modifiers changed from: private */
    public int selectMode;

    public interface OnImageSelectChangedListener {
        void onChange(@NotNull List<LocalMedia> list);

        void onPictureClick(@NotNull LocalMedia localMedia, int i);

        void onPictureClickDone(@NotNull LocalMedia localMedia, int i);

        boolean onShouldStopChangeList(@NotNull ViewHolder viewHolder, @NotNull LocalMedia localMedia);
    }

    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @NotNull
        private FrameLayout borderOverlay;
        @NotNull
        private View contentView;
        @NotNull
        private TextView imageNumber;
        @NotNull
        private ImageView picture;
        @NotNull
        private FrameLayout selectOverlay;
        @NotNull
        private FrameLayout selectedOverlay;

        public ViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "contentView");
            super(view);
            this.contentView = view;
            View findViewById = this.contentView.findViewById(C0010R$id.picture);
            if (findViewById == null) {
                Intrinsics.throwNpe();
            }
            this.picture = (ImageView) findViewById;
            View findViewById2 = this.contentView.findViewById(C0010R$id.image_number);
            if (findViewById2 == null) {
                Intrinsics.throwNpe();
            }
            this.imageNumber = (TextView) findViewById2;
            View findViewById3 = this.contentView.findViewById(C0010R$id.border_overlay);
            if (findViewById3 == null) {
                Intrinsics.throwNpe();
            }
            this.borderOverlay = (FrameLayout) findViewById3;
            View findViewById4 = this.contentView.findViewById(C0010R$id.ordinal_textview);
            if (findViewById4 == null) {
                Intrinsics.throwNpe();
            }
            this.selectedOverlay = (FrameLayout) findViewById4;
            View findViewById5 = this.contentView.findViewById(C0010R$id.border_select);
            if (findViewById5 == null) {
                Intrinsics.throwNpe();
            }
            this.selectOverlay = (FrameLayout) findViewById5;
        }

        @NotNull
        public final View getContentView() {
            return this.contentView;
        }

        public final void setContentView(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "<set-?>");
            this.contentView = view;
        }

        @NotNull
        public final ImageView getPicture() {
            return this.picture;
        }

        public final void setPicture(@NotNull ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.picture = imageView;
        }

        @NotNull
        public final TextView getImageNumber() {
            return this.imageNumber;
        }

        public final void setImageNumber(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.imageNumber = textView;
        }

        @NotNull
        public final FrameLayout getBorderOverlay() {
            return this.borderOverlay;
        }

        public final void setBorderOverlay(@NotNull FrameLayout frameLayout) {
            Intrinsics.checkParameterIsNotNull(frameLayout, "<set-?>");
            this.borderOverlay = frameLayout;
        }

        @NotNull
        public final FrameLayout getSelectedOverlay() {
            return this.selectedOverlay;
        }

        public final void setSelectedOverlay(@NotNull FrameLayout frameLayout) {
            Intrinsics.checkParameterIsNotNull(frameLayout, "<set-?>");
            this.selectedOverlay = frameLayout;
        }

        @NotNull
        public final FrameLayout getSelectOverlay() {
            return this.selectOverlay;
        }

        public final void setSelectOverlay(@NotNull FrameLayout frameLayout) {
            Intrinsics.checkParameterIsNotNull(frameLayout, "<set-?>");
            this.selectOverlay = frameLayout;
        }
    }

    public ImageListAdapter(@NotNull Context context2, int i, @Nullable ArrayList<LocalMedia> arrayList) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.selectMode = i;
        if (arrayList != null) {
            this.selectImages = arrayList;
        }
    }

    @NotNull
    public final List<LocalMedia> getImages() {
        return this.images;
    }

    public final void setImages(@NotNull List<LocalMedia> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.images = list;
    }

    public final void bindImages(@NotNull List<LocalMedia> list) {
        Intrinsics.checkParameterIsNotNull(list, "images");
        this.images = list;
        notifyDataSetChanged();
    }

    public final void bindSelectImages(@NotNull ArrayList<LocalMedia> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "images");
        this.selectImages = arrayList;
        notifyDataSetChanged();
        OnImageSelectChangedListener onImageSelectChangedListener = this.imageSelectChangedListener;
        if (onImageSelectChangedListener != null) {
            if (onImageSelectChangedListener == null) {
                Intrinsics.throwNpe();
            }
            onImageSelectChangedListener.onChange(this.selectImages);
        }
    }

    @NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_picture, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(@NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        LocalMedia localMedia = (LocalMedia) this.images.get(i);
        BaseRequestOptions dontAnimate = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).placeholder((int) C0008R$drawable.image_placeholder)).error((int) C0008R$drawable.image_placeholder)).dontAnimate();
        Intrinsics.checkExpressionValueIsNotNull(dontAnimate, "RequestOptions().centerC…laceholder).dontAnimate()");
        Glide.with(this.context).load(new File(localMedia.getPath())).thumbnail(0.5f).apply((BaseRequestOptions<?>) (RequestOptions) dontAnimate).into(viewHolder2.getPicture());
        selectImage(viewHolder2, localMedia);
        viewHolder2.getContentView().setOnClickListener(new ImageListAdapter$onBindViewHolder$1(this, localMedia, i));
        viewHolder2.getSelectOverlay().setOnClickListener(new ImageListAdapter$onBindViewHolder$2(this, viewHolder2, localMedia));
        viewHolder2.getSelectedOverlay().setOnClickListener(new ImageListAdapter$onBindViewHolder$3(this, viewHolder2, localMedia));
    }

    public int getItemCount() {
        return this.images.size();
    }

    public final void changeCheckboxState(@NotNull ViewHolder viewHolder, @NotNull LocalMedia localMedia) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "contentHolder");
        Intrinsics.checkParameterIsNotNull(localMedia, MessengerShareContentUtility.MEDIA_IMAGE);
        OnImageSelectChangedListener onImageSelectChangedListener = this.imageSelectChangedListener;
        if (onImageSelectChangedListener != null) {
            if (onImageSelectChangedListener == null) {
                Intrinsics.throwNpe();
            }
            if (onImageSelectChangedListener.onShouldStopChangeList(viewHolder, localMedia)) {
                return;
            }
        }
        if (isSelected(localMedia)) {
            ArrayList<LocalMedia> arrayList = this.selectImages;
            ArrayList<LocalMedia> arrayList2 = new ArrayList<>();
            for (Object next : arrayList) {
                if (Intrinsics.areEqual((Object) ((LocalMedia) next).getPath(), (Object) localMedia.getPath())) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (LocalMedia remove : arrayList2) {
                arrayList3.add(Boolean.valueOf(this.selectImages.remove(remove)));
            }
            for (LocalMedia localMedia2 : this.selectImages) {
                if (localMedia.getNum() < localMedia2.getNum()) {
                    localMedia2.setNum(localMedia2.getNum() - 1);
                }
            }
        } else {
            localMedia.setNum(this.selectImages.size() + 1);
            this.selectImages.add(localMedia);
        }
        selectImage(viewHolder, localMedia);
        notifyDataSetChanged();
        OnImageSelectChangedListener onImageSelectChangedListener2 = this.imageSelectChangedListener;
        if (onImageSelectChangedListener2 != null) {
            if (onImageSelectChangedListener2 == null) {
                Intrinsics.throwNpe();
            }
            onImageSelectChangedListener2.onChange(this.selectImages);
        }
    }

    @NotNull
    public final ArrayList<LocalMedia> getSelectedImages() {
        return this.selectImages;
    }

    public final boolean isSelected(@NotNull LocalMedia localMedia) {
        Intrinsics.checkParameterIsNotNull(localMedia, MessengerShareContentUtility.MEDIA_IMAGE);
        ArrayList<LocalMedia> arrayList = this.selectImages;
        ArrayList<LocalMedia> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            if (Intrinsics.areEqual((Object) ((LocalMedia) next).getPath(), (Object) localMedia.getPath())) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        boolean z = false;
        for (LocalMedia num : arrayList2) {
            localMedia.setNum(num.getNum());
            z = true;
            arrayList3.add(Unit.INSTANCE);
        }
        return z;
    }

    private final void selectImage(ViewHolder viewHolder, LocalMedia localMedia) {
        if (isSelected(localMedia)) {
            viewHolder.getImageNumber().setText(String.valueOf(localMedia.getNum()));
            viewHolder.getPicture().setColorFilter(Color.parseColor("#80000000"), Mode.SRC_ATOP);
            viewHolder.getBorderOverlay().setVisibility(0);
            viewHolder.getSelectOverlay().setVisibility(8);
        } else {
            viewHolder.getPicture().setColorFilter(Color.parseColor("#20000000"), Mode.SRC_ATOP);
            viewHolder.getBorderOverlay().setVisibility(8);
            viewHolder.getSelectOverlay().setVisibility(0);
        }
        if (this.selectMode == ImageSelectorActivity.Companion.getMODE_SINGLE() || this.selectMode == ImageSelectorActivity.Companion.getMODE_SHOWROOM()) {
            viewHolder.getSelectOverlay().setVisibility(8);
            viewHolder.getBorderOverlay().setVisibility(8);
        }
    }

    public final void setOnImageSelectChangedListener(@NotNull OnImageSelectChangedListener onImageSelectChangedListener) {
        Intrinsics.checkParameterIsNotNull(onImageSelectChangedListener, "imageSelectChangedListener");
        this.imageSelectChangedListener = onImageSelectChangedListener;
    }
}
