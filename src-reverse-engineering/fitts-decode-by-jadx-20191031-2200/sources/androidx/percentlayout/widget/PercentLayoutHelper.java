package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.percentlayout.R;

@Deprecated
public class PercentLayoutHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "PercentLayout";
    private static final boolean VERBOSE = false;
    private final ViewGroup mHost;

    @Deprecated
    public static class PercentLayoutInfo {
        public float aspectRatio;
        public float bottomMarginPercent = -1.0f;
        public float endMarginPercent = -1.0f;
        public float heightPercent = -1.0f;
        public float leftMarginPercent = -1.0f;
        final PercentMarginLayoutParams mPreservedParams = new PercentMarginLayoutParams(0, 0);
        public float rightMarginPercent = -1.0f;
        public float startMarginPercent = -1.0f;
        public float topMarginPercent = -1.0f;
        public float widthPercent = -1.0f;

        public void fillLayoutParams(LayoutParams layoutParams, int i, int i2) {
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            percentMarginLayoutParams.width = layoutParams.width;
            percentMarginLayoutParams.height = layoutParams.height;
            boolean z = false;
            boolean z2 = (percentMarginLayoutParams.mIsWidthComputedFromAspectRatio || percentMarginLayoutParams.width == 0) && this.widthPercent < 0.0f;
            PercentMarginLayoutParams percentMarginLayoutParams2 = this.mPreservedParams;
            if ((percentMarginLayoutParams2.mIsHeightComputedFromAspectRatio || percentMarginLayoutParams2.height == 0) && this.heightPercent < 0.0f) {
                z = true;
            }
            float f = this.widthPercent;
            if (f >= 0.0f) {
                layoutParams.width = Math.round(((float) i) * f);
            }
            float f2 = this.heightPercent;
            if (f2 >= 0.0f) {
                layoutParams.height = Math.round(((float) i2) * f2);
            }
            float f3 = this.aspectRatio;
            if (f3 >= 0.0f) {
                if (z2) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * f3);
                    this.mPreservedParams.mIsWidthComputedFromAspectRatio = true;
                }
                if (z) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.aspectRatio);
                    this.mPreservedParams.mIsHeightComputedFromAspectRatio = true;
                }
            }
        }

        @Deprecated
        public void fillMarginLayoutParams(MarginLayoutParams marginLayoutParams, int i, int i2) {
            fillMarginLayoutParams(null, marginLayoutParams, i, i2);
        }

        public void fillMarginLayoutParams(View view, MarginLayoutParams marginLayoutParams, int i, int i2) {
            fillLayoutParams(marginLayoutParams, i, i2);
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            percentMarginLayoutParams.leftMargin = marginLayoutParams.leftMargin;
            percentMarginLayoutParams.topMargin = marginLayoutParams.topMargin;
            percentMarginLayoutParams.rightMargin = marginLayoutParams.rightMargin;
            percentMarginLayoutParams.bottomMargin = marginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(percentMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(this.mPreservedParams, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
            float f = this.leftMarginPercent;
            if (f >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(((float) i) * f);
            }
            float f2 = this.topMarginPercent;
            if (f2 >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(((float) i2) * f2);
            }
            float f3 = this.rightMarginPercent;
            if (f3 >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(((float) i) * f3);
            }
            float f4 = this.bottomMarginPercent;
            if (f4 >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(((float) i2) * f4);
            }
            boolean z = false;
            float f5 = this.startMarginPercent;
            if (f5 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, Math.round(((float) i) * f5));
                z = true;
            }
            float f6 = this.endMarginPercent;
            if (f6 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, Math.round(((float) i) * f6));
                z = true;
            }
            if (z && view != null) {
                MarginLayoutParamsCompat.resolveLayoutDirection(marginLayoutParams, ViewCompat.getLayoutDirection(view));
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.widthPercent), Float.valueOf(this.heightPercent), Float.valueOf(this.leftMarginPercent), Float.valueOf(this.topMarginPercent), Float.valueOf(this.rightMarginPercent), Float.valueOf(this.bottomMarginPercent), Float.valueOf(this.startMarginPercent), Float.valueOf(this.endMarginPercent)});
        }

        public void restoreMarginLayoutParams(MarginLayoutParams marginLayoutParams) {
            restoreLayoutParams(marginLayoutParams);
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            marginLayoutParams.leftMargin = percentMarginLayoutParams.leftMargin;
            marginLayoutParams.topMargin = percentMarginLayoutParams.topMargin;
            marginLayoutParams.rightMargin = percentMarginLayoutParams.rightMargin;
            marginLayoutParams.bottomMargin = percentMarginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(percentMarginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.mPreservedParams));
        }

        public void restoreLayoutParams(LayoutParams layoutParams) {
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            if (!percentMarginLayoutParams.mIsWidthComputedFromAspectRatio) {
                layoutParams.width = percentMarginLayoutParams.width;
            }
            PercentMarginLayoutParams percentMarginLayoutParams2 = this.mPreservedParams;
            if (!percentMarginLayoutParams2.mIsHeightComputedFromAspectRatio) {
                layoutParams.height = percentMarginLayoutParams2.height;
            }
            PercentMarginLayoutParams percentMarginLayoutParams3 = this.mPreservedParams;
            percentMarginLayoutParams3.mIsWidthComputedFromAspectRatio = false;
            percentMarginLayoutParams3.mIsHeightComputedFromAspectRatio = false;
        }
    }

    @Deprecated
    public interface PercentLayoutParams {
        PercentLayoutInfo getPercentLayoutInfo();
    }

    static class PercentMarginLayoutParams extends MarginLayoutParams {
        boolean mIsHeightComputedFromAspectRatio;
        boolean mIsWidthComputedFromAspectRatio;

        public PercentMarginLayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public PercentLayoutHelper(@NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.mHost = viewGroup;
            return;
        }
        throw new IllegalArgumentException("host must be non-null");
    }

    public static void fetchWidthAndHeight(LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    public void adjustChildren(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - this.mHost.getPaddingLeft()) - this.mHost.getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - this.mHost.getPaddingTop()) - this.mHost.getPaddingBottom();
        int childCount = this.mHost.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mHost.getChildAt(i3);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo();
                if (percentLayoutInfo != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        percentLayoutInfo.fillMarginLayoutParams(childAt, (MarginLayoutParams) layoutParams, size, size2);
                    } else {
                        percentLayoutInfo.fillLayoutParams(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    public static PercentLayoutInfo getPercentLayoutInfo(Context context, AttributeSet attributeSet) {
        PercentLayoutInfo percentLayoutInfo;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            percentLayoutInfo = new PercentLayoutInfo();
            percentLayoutInfo.widthPercent = fraction;
        } else {
            percentLayoutInfo = null;
        }
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.heightPercent = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction3;
            percentLayoutInfo.topMarginPercent = fraction3;
            percentLayoutInfo.rightMarginPercent = fraction3;
            percentLayoutInfo.bottomMarginPercent = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.topMarginPercent = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.rightMarginPercent = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.bottomMarginPercent = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.startMarginPercent = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.endMarginPercent = fraction9;
        }
        float fraction10 = obtainStyledAttributes.getFraction(R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction10 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.aspectRatio = fraction10;
        }
        obtainStyledAttributes.recycle();
        return percentLayoutInfo;
    }

    public void restoreOriginalParams() {
        int childCount = this.mHost.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = this.mHost.getChildAt(i).getLayoutParams();
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo();
                if (percentLayoutInfo != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        percentLayoutInfo.restoreMarginLayoutParams((MarginLayoutParams) layoutParams);
                    } else {
                        percentLayoutInfo.restoreLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public boolean handleMeasuredStateTooSmall() {
        int childCount = this.mHost.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mHost.getChildAt(i);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo();
                if (percentLayoutInfo != null) {
                    if (shouldHandleMeasuredWidthTooSmall(childAt, percentLayoutInfo)) {
                        layoutParams.width = -2;
                        z = true;
                    }
                    if (shouldHandleMeasuredHeightTooSmall(childAt, percentLayoutInfo)) {
                        layoutParams.height = -2;
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean shouldHandleMeasuredWidthTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216 && percentLayoutInfo.widthPercent >= 0.0f && percentLayoutInfo.mPreservedParams.width == -2;
    }

    private static boolean shouldHandleMeasuredHeightTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredHeightAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216 && percentLayoutInfo.heightPercent >= 0.0f && percentLayoutInfo.mPreservedParams.height == -2;
    }
}
