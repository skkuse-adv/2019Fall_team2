package com.isseiaoki.simplecropview.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;

@TargetApi(14)
public class ValueAnimatorV14 implements SimpleValueAnimator, AnimatorListener, AnimatorUpdateListener {
    private ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    private SimpleValueAnimatorListener animatorListener = new SimpleValueAnimatorListener(this) {
        public void onAnimationFinished() {
        }

        public void onAnimationStarted() {
        }

        public void onAnimationUpdated(float f) {
        }
    };

    public void onAnimationRepeat(Animator animator2) {
    }

    public ValueAnimatorV14(Interpolator interpolator) {
        this.animator.addListener(this);
        this.animator.addUpdateListener(this);
        this.animator.setInterpolator(interpolator);
    }

    public void startAnimation(long j) {
        if (j >= 0) {
            this.animator.setDuration(j);
        } else {
            this.animator.setDuration(150);
        }
        this.animator.start();
    }

    public void cancelAnimation() {
        this.animator.cancel();
    }

    public boolean isAnimationStarted() {
        return this.animator.isStarted();
    }

    public void addAnimatorListener(SimpleValueAnimatorListener simpleValueAnimatorListener) {
        if (simpleValueAnimatorListener != null) {
            this.animatorListener = simpleValueAnimatorListener;
        }
    }

    public void onAnimationStart(Animator animator2) {
        this.animatorListener.onAnimationStarted();
    }

    public void onAnimationEnd(Animator animator2) {
        this.animatorListener.onAnimationFinished();
    }

    public void onAnimationCancel(Animator animator2) {
        this.animatorListener.onAnimationFinished();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.animatorListener.onAnimationUpdated(valueAnimator.getAnimatedFraction());
    }
}
