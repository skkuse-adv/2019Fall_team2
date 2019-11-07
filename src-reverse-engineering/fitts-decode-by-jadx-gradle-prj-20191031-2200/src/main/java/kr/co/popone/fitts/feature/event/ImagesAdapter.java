package kr.co.popone.fitts.feature.event;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse.ButtonProperties;
import kr.co.popone.fitts.model.event.EventAPI.RemotePushContent;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImagesAdapter extends Adapter<ViewHolder> {
    private final OnClickListener actionButtonCLickListener = new ImagesAdapter$actionButtonCLickListener$1(this);
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    @Nullable
    private RemotePushContent remotePushContent;
    private final Point windowSize;

    public static final class ActionButtonItemViewHolder extends ViewHolder {
        @NotNull
        private final Button actionButton;

        public ActionButtonItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.actionButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.actionButton)");
            this.actionButton = (Button) findViewById;
        }

        @NotNull
        public final Button getActionButton() {
            return this.actionButton;
        }
    }

    public interface Delegate {
        void actionButtonClicked();
    }

    public static final class ImageItemViewHolder extends ViewHolder {
        @NotNull
        private final ImageView imageView;

        public ImageItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            this.imageView = (ImageView) view;
        }

        @NotNull
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    public ImagesAdapter(@NotNull Context context2, @NotNull Point point, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(point, "windowSize");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.windowSize = point;
        this.delegate = delegate2;
    }

    @Nullable
    public final RemotePushContent getRemotePushContent() {
        return this.remotePushContent;
    }

    public final void setRemotePushContent(@Nullable RemotePushContent remotePushContent2) {
        this.remotePushContent = remotePushContent2;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i != 0) {
            View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_action_button, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "it");
            ActionButtonItemViewHolder actionButtonItemViewHolder = new ActionButtonItemViewHolder(inflate);
            actionButtonItemViewHolder.getActionButton().setOnClickListener(this.actionButtonCLickListener);
            return actionButtonItemViewHolder;
        }
        View inflate2 = LayoutInflater.from(this.context).inflate(C0013R$layout.item_image, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "view");
        return new ImageItemViewHolder(inflate2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemViewType(int r3) {
        /*
            r2 = this;
            kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r0 = r2.remotePushContent
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.util.List r0 = r0.getImages()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r3 >= r0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 1
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.ImagesAdapter.getItemViewType(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemCount() {
        /*
            r3 = this;
            kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r0 = r3.remotePushContent
            r1 = 0
            if (r0 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.getImages()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r2 = r3.remotePushContent
            if (r2 == 0) goto L_0x001c
            kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r2 = r2.getButton()
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            if (r2 == 0) goto L_0x0020
            r1 = 1
        L_0x0020:
            int r1 = r1 + r0
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.ImagesAdapter.getItemCount():int");
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        int i2 = 0;
        if (viewHolder instanceof ImageItemViewHolder) {
            RemotePushContent remotePushContent2 = this.remotePushContent;
            if (remotePushContent2 == null) {
                Intrinsics.throwNpe();
            }
            ImageUrlWithRatio imageUrlWithRatio = (ImageUrlWithRatio) remotePushContent2.getImages().get(i);
            int i3 = this.windowSize.x;
            float f = (float) 0;
            int roundToInt = imageUrlWithRatio.getRatio() > f ? MathKt__MathJVMKt.roundToInt(((float) i3) / imageUrlWithRatio.getRatio()) : 0;
            if (roundToInt > UIExtensions.INSTANCE.getMaxTexturesSize()) {
                roundToInt = UIExtensions.INSTANCE.getMaxTexturesSize();
                i3 = MathKt__MathJVMKt.roundToInt(((float) roundToInt) * imageUrlWithRatio.getRatio());
            }
            ImageItemViewHolder imageItemViewHolder = (ImageItemViewHolder) viewHolder;
            Glide.with(this.context).load(imageUrlWithRatio.getUrl()).apply(new RequestOptions().override(i3, roundToInt)).into(imageItemViewHolder.getImageView());
            LayoutParams layoutParams = imageItemViewHolder.getImageView().getLayoutParams();
            if (imageUrlWithRatio.getRatio() > f) {
                i2 = MathKt__MathJVMKt.roundToInt(((float) this.windowSize.x) / imageUrlWithRatio.getRatio());
            }
            layoutParams.height = i2;
        } else if (viewHolder instanceof ActionButtonItemViewHolder) {
            RemotePushContent remotePushContent3 = this.remotePushContent;
            if (remotePushContent3 == null) {
                Intrinsics.throwNpe();
            }
            ButtonProperties button = remotePushContent3.getButton();
            if (button == null) {
                Intrinsics.throwNpe();
            }
            ActionButtonItemViewHolder actionButtonItemViewHolder = (ActionButtonItemViewHolder) viewHolder;
            actionButtonItemViewHolder.getActionButton().setVisibility(0);
            actionButtonItemViewHolder.getActionButton().setText(button.getTitle());
            actionButtonItemViewHolder.getActionButton().setTextSize(2, (float) button.getFontSize());
            actionButtonItemViewHolder.getActionButton().setTextColor(Color.parseColor(button.getTextColor()));
            Drawable background = actionButtonItemViewHolder.getActionButton().getBackground();
            if (background != null) {
                ((GradientDrawable) background).setColor(Color.parseColor(button.getBackgroundColor()));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }
}
