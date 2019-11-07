package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.AnimatorRes;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class CircleIndicator extends LinearLayout {
    /* access modifiers changed from: private */
    public Animator mAnimatorIn;
    /* access modifiers changed from: private */
    public Animator mAnimatorOut;
    private int mAnimatorResId = R$animator.scale_with_alpha;
    private int mAnimatorReverseResId = 0;
    private Animator mImmediateAnimatorIn;
    private Animator mImmediateAnimatorOut;
    /* access modifiers changed from: private */
    public int mIndicatorBackgroundResId;
    private int mIndicatorHeight = -1;
    private int mIndicatorMargin = -1;
    /* access modifiers changed from: private */
    public int mIndicatorUnselectedBackgroundResId;
    private int mIndicatorWidth = -1;
    private DataSetObserver mInternalDataSetObserver;
    private final OnPageChangeListener mInternalPageChangeListener;
    /* access modifiers changed from: private */
    public int mLastPosition;
    /* access modifiers changed from: private */
    public ViewPager mViewpager;

    private class ReverseInterpolator implements Interpolator {
        private ReverseInterpolator(CircleIndicator circleIndicator) {
        }

        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        int i = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0) {
                        CircleIndicator circleIndicator = CircleIndicator.this;
                        View childAt = circleIndicator.getChildAt(circleIndicator.mLastPosition);
                        if (childAt != null) {
                            childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                            CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                            CircleIndicator.this.mAnimatorIn.start();
                        }
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                        CircleIndicator.this.mAnimatorOut.start();
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager != null) {
                    int count = CircleIndicator.this.mViewpager.getAdapter().getCount();
                    if (count != CircleIndicator.this.getChildCount()) {
                        if (CircleIndicator.this.mLastPosition < count) {
                            CircleIndicator circleIndicator = CircleIndicator.this;
                            circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                        } else {
                            CircleIndicator.this.mLastPosition = -1;
                        }
                        CircleIndicator.this.createIndicators();
                    }
                }
            }
        };
        init(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i;
        this.mIndicatorUnselectedBackgroundResId = i;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0) {
                        CircleIndicator circleIndicator = CircleIndicator.this;
                        View childAt = circleIndicator.getChildAt(circleIndicator.mLastPosition);
                        if (childAt != null) {
                            childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                            CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                            CircleIndicator.this.mAnimatorIn.start();
                        }
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                        CircleIndicator.this.mAnimatorOut.start();
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager != null) {
                    int count = CircleIndicator.this.mViewpager.getAdapter().getCount();
                    if (count != CircleIndicator.this.getChildCount()) {
                        if (CircleIndicator.this.mLastPosition < count) {
                            CircleIndicator circleIndicator = CircleIndicator.this;
                            circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                        } else {
                            CircleIndicator.this.mLastPosition = -1;
                        }
                        CircleIndicator.this.createIndicators();
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i2;
        this.mIndicatorUnselectedBackgroundResId = i2;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0) {
                        CircleIndicator circleIndicator = CircleIndicator.this;
                        View childAt = circleIndicator.getChildAt(circleIndicator.mLastPosition);
                        if (childAt != null) {
                            childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                            CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                            CircleIndicator.this.mAnimatorIn.start();
                        }
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                        CircleIndicator.this.mAnimatorOut.start();
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager != null) {
                    int count = CircleIndicator.this.mViewpager.getAdapter().getCount();
                    if (count != CircleIndicator.this.getChildCount()) {
                        if (CircleIndicator.this.mLastPosition < count) {
                            CircleIndicator circleIndicator = CircleIndicator.this;
                            circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                        } else {
                            CircleIndicator.this.mLastPosition = -1;
                        }
                        CircleIndicator.this.createIndicators();
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3 = R$drawable.white_radius;
        this.mIndicatorBackgroundResId = i3;
        this.mIndicatorUnselectedBackgroundResId = i3;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() != null && CircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                        CircleIndicator.this.mAnimatorIn.end();
                        CircleIndicator.this.mAnimatorIn.cancel();
                    }
                    if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                        CircleIndicator.this.mAnimatorOut.end();
                        CircleIndicator.this.mAnimatorOut.cancel();
                    }
                    if (CircleIndicator.this.mLastPosition >= 0) {
                        CircleIndicator circleIndicator = CircleIndicator.this;
                        View childAt = circleIndicator.getChildAt(circleIndicator.mLastPosition);
                        if (childAt != null) {
                            childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                            CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                            CircleIndicator.this.mAnimatorIn.start();
                        }
                    }
                    View childAt2 = CircleIndicator.this.getChildAt(i);
                    if (childAt2 != null) {
                        childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                        CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                        CircleIndicator.this.mAnimatorOut.start();
                    }
                    CircleIndicator.this.mLastPosition = i;
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager != null) {
                    int count = CircleIndicator.this.mViewpager.getAdapter().getCount();
                    if (count != CircleIndicator.this.getChildCount()) {
                        if (CircleIndicator.this.mLastPosition < count) {
                            CircleIndicator circleIndicator = CircleIndicator.this;
                            circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                        } else {
                            CircleIndicator.this.mLastPosition = -1;
                        }
                        CircleIndicator.this.createIndicators();
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        handleTypedArray(context, attributeSet);
        checkIndicatorConfig(context);
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleIndicator);
            this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_width, -1);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_height, -1);
            this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CircleIndicator_ci_margin, -1);
            this.mAnimatorResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_animator, R$animator.scale_with_alpha);
            int i = 0;
            this.mAnimatorReverseResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_animator_reverse, 0);
            this.mIndicatorBackgroundResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_drawable, R$drawable.white_radius);
            this.mIndicatorUnselectedBackgroundResId = obtainStyledAttributes.getResourceId(R$styleable.CircleIndicator_ci_drawable_unselected, this.mIndicatorBackgroundResId);
            if (obtainStyledAttributes.getInt(R$styleable.CircleIndicator_ci_orientation, -1) == 1) {
                i = 1;
            }
            setOrientation(i);
            int i2 = obtainStyledAttributes.getInt(R$styleable.CircleIndicator_ci_gravity, -1);
            if (i2 < 0) {
                i2 = 17;
            }
            setGravity(i2);
            obtainStyledAttributes.recycle();
        }
    }

    public void configureIndicator(int i, int i2, int i3) {
        int i4 = R$animator.scale_with_alpha;
        int i5 = R$drawable.white_radius;
        configureIndicator(i, i2, i3, i4, 0, i5, i5);
    }

    public void configureIndicator(int i, int i2, int i3, @AnimatorRes int i4, @AnimatorRes int i5, @DrawableRes int i6, @DrawableRes int i7) {
        this.mIndicatorWidth = i;
        this.mIndicatorHeight = i2;
        this.mIndicatorMargin = i3;
        this.mAnimatorResId = i4;
        this.mAnimatorReverseResId = i5;
        this.mIndicatorBackgroundResId = i6;
        this.mIndicatorUnselectedBackgroundResId = i7;
        checkIndicatorConfig(getContext());
    }

    private void checkIndicatorConfig(Context context) {
        int i = this.mIndicatorWidth;
        if (i < 0) {
            i = dip2px(5.0f);
        }
        this.mIndicatorWidth = i;
        int i2 = this.mIndicatorHeight;
        if (i2 < 0) {
            i2 = dip2px(5.0f);
        }
        this.mIndicatorHeight = i2;
        int i3 = this.mIndicatorMargin;
        if (i3 < 0) {
            i3 = dip2px(5.0f);
        }
        this.mIndicatorMargin = i3;
        int i4 = this.mAnimatorResId;
        if (i4 == 0) {
            i4 = R$animator.scale_with_alpha;
        }
        this.mAnimatorResId = i4;
        this.mAnimatorOut = createAnimatorOut(context);
        this.mImmediateAnimatorOut = createAnimatorOut(context);
        this.mImmediateAnimatorOut.setDuration(0);
        this.mAnimatorIn = createAnimatorIn(context);
        this.mImmediateAnimatorIn = createAnimatorIn(context);
        this.mImmediateAnimatorIn.setDuration(0);
        int i5 = this.mIndicatorBackgroundResId;
        if (i5 == 0) {
            i5 = R$drawable.white_radius;
        }
        this.mIndicatorBackgroundResId = i5;
        int i6 = this.mIndicatorUnselectedBackgroundResId;
        if (i6 == 0) {
            i6 = this.mIndicatorBackgroundResId;
        }
        this.mIndicatorUnselectedBackgroundResId = i6;
    }

    private Animator createAnimatorOut(Context context) {
        return AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
    }

    private Animator createAnimatorIn(Context context) {
        int i = this.mAnimatorReverseResId;
        if (i != 0) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
        loadAnimator.setInterpolator(new ReverseInterpolator());
        return loadAnimator;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewpager = viewPager;
        ViewPager viewPager2 = this.mViewpager;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.mViewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
            this.mViewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
            this.mInternalPageChangeListener.onPageSelected(this.mViewpager.getCurrentItem());
        }
    }

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.mViewpager;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
            this.mViewpager.addOnPageChangeListener(onPageChangeListener);
            return;
        }
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    /* access modifiers changed from: private */
    public void createIndicators() {
        removeAllViews();
        int count = this.mViewpager.getAdapter().getCount();
        if (count > 0) {
            int currentItem = this.mViewpager.getCurrentItem();
            int orientation = getOrientation();
            for (int i = 0; i < count; i++) {
                if (currentItem == i) {
                    addIndicator(orientation, this.mIndicatorBackgroundResId, this.mImmediateAnimatorOut);
                } else {
                    addIndicator(orientation, this.mIndicatorUnselectedBackgroundResId, this.mImmediateAnimatorIn);
                }
            }
        }
    }

    private void addIndicator(int i, @DrawableRes int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.mIndicatorWidth, this.mIndicatorHeight);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (i == 0) {
            int i3 = this.mIndicatorMargin;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        } else {
            int i4 = this.mIndicatorMargin;
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
