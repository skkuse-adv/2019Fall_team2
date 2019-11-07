package kr.co.popone.fitts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.CropTransformation.CropType;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImageViewExtensionKt {
    private static final DrawableTransitionOptions transitionOption;

    static {
        DrawableTransitionOptions withCrossFade = DrawableTransitionOptions.withCrossFade(300);
        Intrinsics.checkExpressionValueIsNotNull(withCrossFade, "DrawableTransitionOptions.withCrossFade(300)");
        transitionOption = withCrossFade;
    }

    public static final void loadImageAsPost(@NotNull ImageView imageView, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        with.load(str).thumbnail(Glide.with(imageView.getContext()).load((Drawable) new ColorDrawable(Color.parseColor(str2)))).transition(transitionOption).into(imageView);
    }

    public static final void loadImageAsProduct(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        ((RequestBuilder) with.load(str).error((int) C0006R$color.gray1)).transition(transitionOption).into(imageView);
    }

    public static final void loadImageAsProductNotAnim(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        ((RequestBuilder) ((RequestBuilder) with.load(str).dontAnimate()).error((int) C0006R$color.gray1)).transition(transitionOption).into(imageView);
    }

    public static final void loadImageAsProfile(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        ((RequestBuilder) with.load(str).error((int) C0008R$drawable.image_default_profile_large)).into(imageView);
    }

    public static final void loadImageAsCircle(@NotNull ImageView imageView, @NotNull Context context, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        RequestManager with = Glide.with(context);
        with.clear((View) imageView);
        ((RequestBuilder) with.load(str).error((int) C0006R$color.gray1)).into(imageView);
    }

    public static final void loadImage(@NotNull ImageView imageView, @Nullable String str, int i) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        ((RequestBuilder) with.load(str).error(i)).into(imageView);
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "#E7EAEF";
        }
        loadImage(imageView, str, str2);
    }

    public static final void loadImage(@NotNull ImageView imageView, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        ((RequestBuilder) with.load(str).thumbnail(Glide.with(imageView.getContext()).load((Drawable) new ColorDrawable(Color.parseColor(str2)))).error((Drawable) new ColorDrawable(Color.parseColor(str2)))).into(imageView);
    }

    public static final void loadImageWithRatio(@NotNull ImageView imageView, @Nullable String str, float f) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        LayoutParams layoutParams = imageView.getLayoutParams();
        Context context = imageView.getContext();
        String str2 = "context";
        Intrinsics.checkExpressionValueIsNotNull(context, str2);
        layoutParams.height = ContextExtensionKt.getHeightByRatio(context, f);
        RequestManager with = Glide.with(imageView.getContext());
        with.clear((View) imageView);
        RequestBuilder load = with.load(str);
        Context context2 = imageView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, str2);
        int screenWidth = ContextExtensionKt.getScreenWidth(context2);
        Context context3 = imageView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, str2);
        ((RequestBuilder) load.override(screenWidth, ContextExtensionKt.getHeightByRatio(context3, f))).into(imageView);
    }

    public static final void loadImageTopRound(@NotNull ImageView imageView, @NotNull Context context, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        ((RequestBuilder) Glide.with(context).load(str).apply(new RequestOptions().transform((Transformation<Bitmap>) new RoundedCornersTransformation<Bitmap>(10, 0, CornerType.TOP))).thumbnail(0.1f).placeholder((Drawable) new ColorDrawable(Color.parseColor(str2)))).into(imageView);
    }

    public static /* synthetic */ void loadImageAsBitmapCropTop$default(ImageView imageView, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "#E7EAEF";
        }
        loadImageAsBitmapCropTop(imageView, context, str, str2);
    }

    public static final void loadImageAsBitmapCropTop(@NotNull ImageView imageView, @NotNull Context context, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        RequestBuilder requestBuilder = (RequestBuilder) Glide.with(context).asBitmap().load(str).transform((Transformation<Bitmap>) new CropTransformation<Bitmap>(imageView.getWidth(), imageView.getHeight(), CropType.TOP));
        if (str2 == null) {
            str2 = "#E7EAEF";
        }
        requestBuilder.apply(RequestOptions.placeholderOf(getColorDrawableWithRound(context, str2)).error((Drawable) new ColorDrawable(Color.parseColor("#FFFFFF")))).into(imageView);
    }

    private static final Drawable getColorDrawableWithRound(Context context, String str) {
        Drawable drawable = ContextCompat.getDrawable(context, C0008R$drawable.background_corner_5dp);
        if (drawable != null) {
            drawable.setColorFilter(Color.parseColor(str), Mode.SRC_ATOP);
        }
        return drawable;
    }
}
