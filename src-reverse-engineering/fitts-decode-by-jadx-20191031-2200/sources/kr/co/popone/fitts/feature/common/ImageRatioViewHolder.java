package kr.co.popone.fitts.feature.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.action.SchemeAction;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImageRatioViewHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final ImageView imageFeedImageView;
    private final ConstraintLayout rootImageFeedContainer;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_image_ratio;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImageRatioViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_image_ratio, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ImageRatioViewHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SchemeAction {
    }

    public ImageRatioViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.imageFeedImageView = (ImageView) view.findViewById(C0010R$id.iv_image_feed);
        this.rootImageFeedContainer = (ConstraintLayout) view.findViewById(C0010R$id.root_image_feed);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof ImageType) {
            updateImageRatioUi((ImageType) t);
        }
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.imageFeedImageView);
    }

    private final void updateImageRatioUi(ImageType imageType) {
        String str = "imageFeedImageView";
        if (imageType.getImageUrl() != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.rootImageFeedContainer);
            ImageView imageView = this.imageFeedImageView;
            Intrinsics.checkExpressionValueIsNotNull(imageView, str);
            int id = imageView.getId();
            StringBuilder sb = new StringBuilder();
            sb.append(imageType.getImageRatio());
            sb.append(":1");
            constraintSet.setDimensionRatio(id, sb.toString());
            constraintSet.applyTo(this.rootImageFeedContainer);
            ImageView imageView2 = this.imageFeedImageView;
            Intrinsics.checkExpressionValueIsNotNull(imageView2, str);
            ImageViewExtensionKt.loadImageWithRatio(imageView2, imageType.getImageUrl(), (float) imageType.getImageRatio());
            this.itemView.setOnClickListener(new ImageRatioViewHolder$updateImageRatioUi$$inlined$run$lambda$1(imageType, this, imageType));
            return;
        }
        ImageView imageView3 = this.imageFeedImageView;
        Intrinsics.checkExpressionValueIsNotNull(imageView3, str);
        ViewExtensionsKt.gone(imageView3);
    }
}
