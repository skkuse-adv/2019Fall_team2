package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ThemeKt {
    @NotNull
    public static final TypedValue attr(@NotNull Theme theme, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(theme, "receiver$0");
        TypedValue typedValue = new TypedValue();
        if (theme.resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to resolve attribute: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @ColorInt
    public static final int color(@NotNull Theme theme, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(theme, "receiver$0");
        TypedValue attr = attr(theme, i);
        int i2 = attr.type;
        if (i2 >= 28 && i2 <= 31) {
            return attr.data;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attribute value type is not color: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @NotNull
    public static final TypedValue attr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Theme theme = context.getTheme();
        Intrinsics.checkExpressionValueIsNotNull(theme, "theme");
        return attr(theme, i);
    }

    @Dimension(unit = 1)
    public static final int dimenAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        int i2 = attr(context, i).data;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return TypedValue.complexToDimensionPixelSize(i2, resources.getDisplayMetrics());
    }

    @ColorInt
    public static final int colorAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Theme theme = context.getTheme();
        Intrinsics.checkExpressionValueIsNotNull(theme, "theme");
        return color(theme, i);
    }

    @Dimension(unit = 1)
    public static final int dimenAttr(@NotNull AnkoContext<?> ankoContext, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return dimenAttr(ankoContext.getCtx(), i);
    }

    @ColorInt
    public static final int colorAttr(@NotNull AnkoContext<?> ankoContext, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return colorAttr(ankoContext.getCtx(), i);
    }

    @NotNull
    public static final TypedValue attr(@NotNull AnkoContext<?> ankoContext, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "receiver$0");
        return attr(ankoContext.getCtx(), i);
    }

    @Dimension(unit = 1)
    public static final int dimenAttr(@NotNull View view, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dimenAttr(context, i);
    }

    @ColorInt
    public static final int colorAttr(@NotNull View view, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return colorAttr(context, i);
    }

    @NotNull
    public static final TypedValue attr(@NotNull View view, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return attr(context, i);
    }

    @Dimension(unit = 1)
    public static final int dimenAttr(@NotNull Fragment fragment, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return dimenAttr((Context) activity, i);
    }

    @ColorInt
    public static final int colorAttr(@NotNull Fragment fragment, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return colorAttr((Context) activity, i);
    }

    @NotNull
    public static final TypedValue attr(@NotNull Fragment fragment, @AttrRes int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return attr((Context) activity, i);
    }
}
