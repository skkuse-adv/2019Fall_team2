package kr.co.popone.fitts.feature.alarm;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface newType;

    public CustomTypefaceSpan(@NotNull String str, @NotNull Typeface typeface) {
        Intrinsics.checkParameterIsNotNull(str, "family");
        Intrinsics.checkParameterIsNotNull(typeface, "newType");
        super(str);
        this.newType = typeface;
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "ds");
        applyCustomTypeFace(textPaint, this.newType);
    }

    public void updateMeasureState(@NotNull TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "paint");
        applyCustomTypeFace(textPaint, this.newType);
    }

    private final void applyCustomTypeFace(Paint paint, Typeface typeface) {
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 != null ? typeface2.getStyle() : 0) & (typeface.getStyle() ^ -1);
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }
}
