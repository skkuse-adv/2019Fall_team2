package org.jetbrains.anko;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CustomViewPropertiesKt {
    public static /* synthetic */ void paddingHorizontal$annotations(View view) {
    }

    public static /* synthetic */ void paddingVertical$annotations(View view) {
    }

    @Nullable
    public static final Drawable getBackgroundDrawable(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return view.getBackground();
    }

    public static final void setBackgroundDrawable(@NotNull View view, @Nullable Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setBackgroundDrawable(drawable);
    }

    public static final int getBackgroundColorResource(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setBackgroundColorResource(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        view.setBackgroundColor(context.getResources().getColor(i));
    }

    public static final int getLeftPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return view.getPaddingLeft();
    }

    public static final void setLeftPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final int getTopPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return view.getPaddingTop();
    }

    public static final void setTopPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final int getRightPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return view.getPaddingRight();
    }

    public static final void setRightPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final int getBottomPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return view.getPaddingBottom();
    }

    public static final void setBottomPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public static final int getPaddingHorizontal(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPaddingHorizontal(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final int getHorizontalPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setHorizontalPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final int getPaddingVertical(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPaddingVertical(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    public static final int getVerticalPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setVerticalPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    public static final int getPadding(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setPadding(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setPadding(i, i, i, i);
    }

    public static final boolean getAllCaps(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setAllCaps(@NotNull TextView textView, boolean z) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        textView.setAllCaps(z);
    }

    public static final int getEms(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setEms(@NotNull TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        textView.setEms(i);
    }

    public static final boolean isSelectable(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        return textView.isTextSelectable();
    }

    public static final void setSelectable(@NotNull TextView textView, boolean z) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        textView.setTextIsSelectable(z);
    }

    public static final int getTextAppearance(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextAppearance(@NotNull TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static final int getTextSizeDimen(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextSizeDimen(@NotNull TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Context context = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        textView.setTextSize(0, context.getResources().getDimension(i));
    }

    public static final int getTextColorResource(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        AnkoInternals.INSTANCE.noGetter();
        throw null;
    }

    public static final void setTextColorResource(@NotNull TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        Context context = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        textView.setTextColor(context.getResources().getColor(i));
    }

    @Nullable
    public static final Drawable getImage(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        return imageView.getDrawable();
    }

    public static final void setImage(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(imageView, "receiver$0");
        imageView.setImageDrawable(drawable);
    }
}
