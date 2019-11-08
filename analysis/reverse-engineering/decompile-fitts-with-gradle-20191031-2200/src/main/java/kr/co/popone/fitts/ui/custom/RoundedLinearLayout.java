package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RoundedLinearLayout extends ConstraintLayout {
    float mCornerRadius;
    Path mPath;

    public RoundedLinearLayout(Context context) {
        super(context);
    }

    public RoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundedLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        this.mPath = new Path();
        Path path = this.mPath;
        float f = this.mCornerRadius;
        path.addRoundRect(rectF, f, f, Direction.CW);
        this.mPath.close();
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = (float) i;
        invalidate();
    }
}
