package kr.co.popone.fitts.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.R$styleable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RoundImageView extends AppCompatImageView {
    private HashMap _$_findViewCache;
    private Float roundRadius;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public RoundImageView(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
    }

    public RoundImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet);
        initRoundRadius(attributeSet);
    }

    public RoundImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet, i);
        initRoundRadius(attributeSet);
    }

    private final void initRoundRadius(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.RoundImageView, 0, 0);
        try {
            this.roundRadius = Float.valueOf(obtainStyledAttributes.getDimension(0, 0.0f));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@Nullable Canvas canvas) {
        Path path = new Path();
        float f = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Float f2 = this.roundRadius;
        float floatValue = f2 != null ? f2.floatValue() : 0.0f;
        Float f3 = this.roundRadius;
        if (f3 != null) {
            f = f3.floatValue();
        }
        path.addRoundRect(rectF, floatValue, f, Direction.CW);
        if (canvas != null) {
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }
}
