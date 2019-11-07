package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.DimenRes;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DimensionsKt {
    public static final int HDPI = 240;
    public static final int LDPI = 120;
    public static final int MAXDPI = 65534;
    public static final int MDPI = 160;
    public static final int TVDPI = 213;
    public static final int XHDPI = 320;
    public static final int XXHDPI = 480;
    public static final int XXXHDPI = 640;

    public static final int dip(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        float f = (float) i;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().density);
    }

    public static final int dip(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().density);
    }

    public static final int sp(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        float f = (float) i;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().scaledDensity);
    }

    public static final int sp(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().scaledDensity);
    }

    public static final float px2dip(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        float f = (float) i;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return f / resources.getDisplayMetrics().density;
    }

    public static final float px2sp(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        float f = (float) i;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return f / resources.getDisplayMetrics().scaledDensity;
    }

    public static final int dimen(@NotNull Context context, @DimenRes int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final int dip(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return dip(ankoContext.getCtx(), i);
    }

    public static final int dip(@NotNull AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return dip(ankoContext.getCtx(), f);
    }

    public static final int sp(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return sp(ankoContext.getCtx(), i);
    }

    public static final int sp(@NotNull AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return sp(ankoContext.getCtx(), f);
    }

    public static final float px2dip(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return px2dip(ankoContext.getCtx(), i);
    }

    public static final float px2sp(@NotNull AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return px2sp(ankoContext.getCtx(), i);
    }

    public static final int dimen(@NotNull AnkoContext<?> ankoContext, @DimenRes int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return dimen(ankoContext.getCtx(), i);
    }

    public static final int dip(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, i);
    }

    public static final int dip(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, f);
    }

    public static final int sp(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, i);
    }

    public static final int sp(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, f);
    }

    public static final float px2dip(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2dip(context, i);
    }

    public static final float px2sp(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2sp(context, i);
    }

    public static final int dimen(@NotNull View view, @DimenRes int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dimen(context, i);
    }

    public static final int dip(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dip((Context) activity, i);
    }

    public static final int dip(@NotNull Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dip((Context) activity, f);
    }

    public static final int sp(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sp((Context) activity, i);
    }

    public static final int sp(@NotNull Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sp((Context) activity, f);
    }

    public static final float px2dip(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return px2dip((Context) activity, i);
    }

    public static final float px2sp(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return px2sp((Context) activity, i);
    }

    public static final int dimen(@NotNull Fragment fragment, @DimenRes int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dimen((Context) activity, i);
    }
}
