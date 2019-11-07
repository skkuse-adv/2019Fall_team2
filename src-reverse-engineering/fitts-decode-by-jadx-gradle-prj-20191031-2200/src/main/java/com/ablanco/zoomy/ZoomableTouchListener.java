package com.ablanco.zoomy;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;

class ZoomableTouchListener implements OnTouchListener, OnScaleGestureListener {
    /* access modifiers changed from: private */
    public boolean mAnimatingZoomEnding = false;
    /* access modifiers changed from: private */
    public ZoomyConfig mConfig;
    /* access modifiers changed from: private */
    public PointF mCurrentMovementMidPoint = new PointF();
    /* access modifiers changed from: private */
    public final DoubleTapListener mDoubleTapListener;
    private Interpolator mEndZoomingInterpolator;
    private Runnable mEndingZoomAction = new Runnable() {
        public void run() {
            ZoomableTouchListener zoomableTouchListener = ZoomableTouchListener.this;
            zoomableTouchListener.removeFromDecorView(zoomableTouchListener.mShadow);
            ZoomableTouchListener zoomableTouchListener2 = ZoomableTouchListener.this;
            zoomableTouchListener2.removeFromDecorView(zoomableTouchListener2.mZoomableView);
            ZoomableTouchListener.this.mTarget.setVisibility(0);
            ZoomableTouchListener.this.mZoomableView = null;
            ZoomableTouchListener.this.mCurrentMovementMidPoint = new PointF();
            ZoomableTouchListener.this.mInitialPinchMidPoint = new PointF();
            ZoomableTouchListener.this.mAnimatingZoomEnding = false;
            ZoomableTouchListener.this.mState = 0;
            if (ZoomableTouchListener.this.mZoomListener != null) {
                ZoomableTouchListener.this.mZoomListener.onViewEndedZooming(ZoomableTouchListener.this.mTarget);
            }
            if (ZoomableTouchListener.this.mConfig.isImmersiveModeEnabled()) {
                ZoomableTouchListener.this.showSystemUI();
            }
        }
    };
    private GestureDetector mGestureDetector;
    private SimpleOnGestureListener mGestureListener = new SimpleOnGestureListener() {
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ZoomableTouchListener.this.mTapListener != null) {
                ZoomableTouchListener.this.mTapListener.onTap(ZoomableTouchListener.this.mTarget);
            }
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (ZoomableTouchListener.this.mLongPressListener != null) {
                ZoomableTouchListener.this.mLongPressListener.onLongPress(ZoomableTouchListener.this.mTarget);
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ZoomableTouchListener.this.mDoubleTapListener != null) {
                ZoomableTouchListener.this.mDoubleTapListener.onDoubleTap(ZoomableTouchListener.this.mTarget);
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public PointF mInitialPinchMidPoint = new PointF();
    /* access modifiers changed from: private */
    public final LongPressListener mLongPressListener;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    /* access modifiers changed from: private */
    public View mShadow;
    /* access modifiers changed from: private */
    public int mState = 0;
    /* access modifiers changed from: private */
    public final TapListener mTapListener;
    /* access modifiers changed from: private */
    public View mTarget;
    private TargetContainer mTargetContainer;
    private Point mTargetViewCords = new Point();
    /* access modifiers changed from: private */
    public ZoomListener mZoomListener;
    /* access modifiers changed from: private */
    public ImageView mZoomableView;

    ZoomableTouchListener(TargetContainer targetContainer, View view, ZoomyConfig zoomyConfig, Interpolator interpolator, ZoomListener zoomListener, TapListener tapListener, LongPressListener longPressListener, DoubleTapListener doubleTapListener) {
        this.mTargetContainer = targetContainer;
        this.mTarget = view;
        this.mConfig = zoomyConfig;
        if (interpolator == null) {
            interpolator = new AccelerateDecelerateInterpolator();
        }
        this.mEndZoomingInterpolator = interpolator;
        this.mScaleGestureDetector = new ScaleGestureDetector(view.getContext(), this);
        this.mGestureDetector = new GestureDetector(view.getContext(), this.mGestureListener);
        this.mZoomListener = zoomListener;
        this.mTapListener = tapListener;
        this.mLongPressListener = longPressListener;
        this.mDoubleTapListener = doubleTapListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r4 != 6) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            boolean r4 = r3.mAnimatingZoomEnding
            r0 = 1
            if (r4 != 0) goto L_0x008f
            int r4 = r5.getPointerCount()
            r1 = 2
            if (r4 <= r1) goto L_0x000e
            goto L_0x008f
        L_0x000e:
            android.view.ScaleGestureDetector r4 = r3.mScaleGestureDetector
            r4.onTouchEvent(r5)
            android.view.GestureDetector r4 = r3.mGestureDetector
            r4.onTouchEvent(r5)
            int r4 = r5.getAction()
            r4 = r4 & 255(0xff, float:3.57E-43)
            if (r4 == 0) goto L_0x0079
            if (r4 == r0) goto L_0x006a
            if (r4 == r1) goto L_0x002e
            r2 = 3
            if (r4 == r2) goto L_0x006a
            r2 = 5
            if (r4 == r2) goto L_0x0079
            r5 = 6
            if (r4 == r5) goto L_0x006a
            goto L_0x008f
        L_0x002e:
            int r4 = r3.mState
            if (r4 != r1) goto L_0x008f
            android.graphics.PointF r4 = r3.mCurrentMovementMidPoint
            com.ablanco.zoomy.MotionUtils.midPointOfEvent(r4, r5)
            android.graphics.PointF r4 = r3.mCurrentMovementMidPoint
            float r5 = r4.x
            android.graphics.PointF r1 = r3.mInitialPinchMidPoint
            float r2 = r1.x
            float r5 = r5 - r2
            r4.x = r5
            float r5 = r4.y
            float r1 = r1.y
            float r5 = r5 - r1
            r4.y = r5
            float r5 = r4.x
            android.graphics.Point r1 = r3.mTargetViewCords
            int r2 = r1.x
            float r2 = (float) r2
            float r5 = r5 + r2
            r4.x = r5
            float r5 = r4.y
            int r1 = r1.y
            float r1 = (float) r1
            float r5 = r5 + r1
            r4.y = r5
            float r5 = r4.x
            float r4 = r4.y
            android.widget.ImageView r1 = r3.mZoomableView
            r1.setX(r5)
            android.widget.ImageView r5 = r3.mZoomableView
            r5.setY(r4)
            goto L_0x008f
        L_0x006a:
            int r4 = r3.mState
            if (r4 == r0) goto L_0x0075
            if (r4 == r1) goto L_0x0071
            goto L_0x008f
        L_0x0071:
            r3.endZoomingView()
            goto L_0x008f
        L_0x0075:
            r4 = 0
            r3.mState = r4
            goto L_0x008f
        L_0x0079:
            int r4 = r3.mState
            if (r4 == 0) goto L_0x008d
            if (r4 == r0) goto L_0x0080
            goto L_0x008f
        L_0x0080:
            r3.mState = r1
            android.graphics.PointF r4 = r3.mInitialPinchMidPoint
            com.ablanco.zoomy.MotionUtils.midPointOfEvent(r4, r5)
            android.view.View r4 = r3.mTarget
            r3.startZoomingView(r4)
            goto L_0x008f
        L_0x008d:
            r3.mState = r0
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ablanco.zoomy.ZoomableTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void endZoomingView() {
        if (this.mConfig.isZoomAnimationEnabled()) {
            this.mAnimatingZoomEnding = true;
            this.mZoomableView.animate().x((float) this.mTargetViewCords.x).y((float) this.mTargetViewCords.y).scaleX(1.0f).scaleY(1.0f).setInterpolator(this.mEndZoomingInterpolator).withEndAction(this.mEndingZoomAction).start();
            return;
        }
        this.mEndingZoomAction.run();
    }

    private void startZoomingView(View view) {
        this.mZoomableView = new ImageView(this.mTarget.getContext());
        this.mZoomableView.setLayoutParams(new LayoutParams(this.mTarget.getWidth(), this.mTarget.getHeight()));
        this.mZoomableView.setImageBitmap(ViewUtils.getBitmapFromView(view));
        this.mTargetViewCords = ViewUtils.getViewAbsoluteCords(view);
        this.mZoomableView.setX((float) this.mTargetViewCords.x);
        this.mZoomableView.setY((float) this.mTargetViewCords.y);
        if (this.mShadow == null) {
            this.mShadow = new View(this.mTarget.getContext());
        }
        this.mShadow.setBackgroundResource(0);
        addToDecorView(this.mShadow);
        addToDecorView(this.mZoomableView);
        disableParentTouch(this.mTarget.getParent());
        this.mTarget.setVisibility(4);
        if (this.mConfig.isImmersiveModeEnabled()) {
            hideSystemUI();
        }
        ZoomListener zoomListener = this.mZoomListener;
        if (zoomListener != null) {
            zoomListener.onViewStartedZooming(this.mTarget);
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.mZoomableView == null) {
            return false;
        }
        this.mScaleFactor *= scaleGestureDetector.getScaleFactor();
        this.mScaleFactor = Math.max(1.0f, Math.min(this.mScaleFactor, 5.0f));
        this.mZoomableView.setScaleX(this.mScaleFactor);
        this.mZoomableView.setScaleY(this.mScaleFactor);
        obscureDecorView(this.mScaleFactor);
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return this.mZoomableView != null;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.mScaleFactor = 1.0f;
    }

    private void addToDecorView(View view) {
        this.mTargetContainer.getDecorView().addView(view);
    }

    /* access modifiers changed from: private */
    public void removeFromDecorView(View view) {
        this.mTargetContainer.getDecorView().removeView(view);
    }

    private void obscureDecorView(float f) {
        this.mShadow.setBackgroundColor(Color.argb((int) (Math.min(0.75f, ((f - 1.0f) / 4.0f) * 2.0f) * 255.0f), 0, 0, 0));
    }

    private void hideSystemUI() {
        this.mTargetContainer.getDecorView().setSystemUiVisibility(262);
    }

    /* access modifiers changed from: private */
    public void showSystemUI() {
        this.mTargetContainer.getDecorView().setSystemUiVisibility(0);
    }

    private void disableParentTouch(ViewParent viewParent) {
        viewParent.requestDisallowInterceptTouchEvent(true);
        if (viewParent.getParent() != null) {
            disableParentTouch(viewParent.getParent());
        }
    }
}
