package com.isseiaoki.simplecropview.animation;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ValueAnimatorV8 implements SimpleValueAnimator {
    private static final int UPDATE_SPAN = Math.round(33.333332f);
    /* access modifiers changed from: private */
    public SimpleValueAnimatorListener animatorListener = new SimpleValueAnimatorListener(this) {
        public void onAnimationFinished() {
        }

        public void onAnimationStarted() {
        }

        public void onAnimationUpdated(float f) {
        }
    };
    long duration;
    boolean isAnimationStarted = false;
    /* access modifiers changed from: private */
    public Interpolator mInterpolator;
    private final Runnable runnable = new Runnable() {
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            ValueAnimatorV8 valueAnimatorV8 = ValueAnimatorV8.this;
            long j = uptimeMillis - valueAnimatorV8.start;
            if (j > valueAnimatorV8.duration) {
                valueAnimatorV8.isAnimationStarted = false;
                valueAnimatorV8.animatorListener.onAnimationFinished();
                ValueAnimatorV8.this.service.shutdown();
                return;
            }
            ValueAnimatorV8.this.animatorListener.onAnimationUpdated(Math.min(valueAnimatorV8.mInterpolator.getInterpolation(((float) j) / ((float) ValueAnimatorV8.this.duration)), 1.0f));
        }
    };
    ScheduledExecutorService service;
    long start;

    public ValueAnimatorV8(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void startAnimation(long j) {
        if (j >= 0) {
            this.duration = j;
        } else {
            this.duration = 150;
        }
        this.isAnimationStarted = true;
        this.animatorListener.onAnimationStarted();
        this.start = SystemClock.uptimeMillis();
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.service.scheduleAtFixedRate(this.runnable, 0, (long) UPDATE_SPAN, TimeUnit.MILLISECONDS);
    }

    public void cancelAnimation() {
        this.isAnimationStarted = false;
        this.service.shutdown();
        this.animatorListener.onAnimationFinished();
    }

    public boolean isAnimationStarted() {
        return this.isAnimationStarted;
    }

    public void addAnimatorListener(SimpleValueAnimatorListener simpleValueAnimatorListener) {
        if (simpleValueAnimatorListener != null) {
            this.animatorListener = simpleValueAnimatorListener;
        }
    }
}
