package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.percentlayout.widget.PercentLayoutHelper.PercentLayoutInfo;
import androidx.percentlayout.widget.PercentLayoutHelper.PercentLayoutParams;

@Deprecated
public class PercentFrameLayout extends FrameLayout {
    private final PercentLayoutHelper mHelper = new PercentLayoutHelper(this);

    @Deprecated
    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams implements PercentLayoutParams {
        private PercentLayoutInfo mPercentLayoutInfo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        @RequiresApi(19)
        public LayoutParams(LayoutParams layoutParams) {
            this((android.widget.FrameLayout.LayoutParams) layoutParams);
            this.mPercentLayoutInfo = layoutParams.mPercentLayoutInfo;
        }

        public PercentLayoutInfo getPercentLayoutInfo() {
            if (this.mPercentLayoutInfo == null) {
                this.mPercentLayoutInfo = new PercentLayoutInfo();
            }
            return this.mPercentLayoutInfo;
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            PercentLayoutHelper.fetchWidthAndHeight(this, typedArray, i, i2);
        }
    }

    public PercentFrameLayout(Context context) {
        super(context);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mHelper.adjustChildren(i, i2);
        super.onMeasure(i, i2);
        if (this.mHelper.handleMeasuredStateTooSmall()) {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mHelper.restoreOriginalParams();
    }
}
