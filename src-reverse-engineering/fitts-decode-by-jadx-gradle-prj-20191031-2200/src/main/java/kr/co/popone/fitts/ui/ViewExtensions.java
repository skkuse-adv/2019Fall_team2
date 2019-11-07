package kr.co.popone.fitts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ViewExtensions {
    public static final ViewExtensions INSTANCE = new ViewExtensions();

    private ViewExtensions() {
    }

    public final int dpToPx(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        float f = (float) i;
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public final int dpToPx(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public final int spToPx(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
    }
}
