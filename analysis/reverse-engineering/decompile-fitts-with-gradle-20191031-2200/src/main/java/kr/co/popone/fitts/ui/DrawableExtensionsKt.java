package kr.co.popone.fitts.ui;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DrawableExtensionsKt {
    public static final void setFittsColor(@NotNull Drawable drawable, int i) {
        Intrinsics.checkParameterIsNotNull(drawable, "receiver$0");
        if (drawable instanceof ShapeDrawable) {
            Paint paint = ((ShapeDrawable) drawable).getPaint();
            Intrinsics.checkExpressionValueIsNotNull(paint, "this.paint");
            paint.setColor(i);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i);
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i);
        }
    }
}
