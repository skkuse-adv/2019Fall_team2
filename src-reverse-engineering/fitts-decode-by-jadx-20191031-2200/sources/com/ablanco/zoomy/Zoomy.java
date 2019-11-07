package com.ablanco.zoomy;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.view.View;
import android.view.animation.Interpolator;

public class Zoomy {
    /* access modifiers changed from: private */
    public static ZoomyConfig mDefaultConfig = new ZoomyConfig();

    public static class Builder {
        private ZoomyConfig mConfig;
        private boolean mDisposed = false;
        private LongPressListener mLongPressListener;
        private TapListener mTapListener;
        private TargetContainer mTargetContainer;
        private View mTargetView;
        private Interpolator mZoomInterpolator;
        private ZoomListener mZoomListener;
        private DoubleTapListener mdDoubleTapListener;

        public Builder(Activity activity) {
            this.mTargetContainer = new ActivityContainer(activity);
        }

        public Builder(Dialog dialog) {
            this.mTargetContainer = new DialogContainer(dialog);
        }

        public Builder(DialogFragment dialogFragment) {
            this.mTargetContainer = new DialogFragmentContainer(dialogFragment);
        }

        public Builder target(View view) {
            this.mTargetView = view;
            return this;
        }

        public Builder animateZooming(boolean z) {
            checkNotDisposed();
            if (this.mConfig == null) {
                this.mConfig = new ZoomyConfig();
            }
            this.mConfig.setZoomAnimationEnabled(z);
            return this;
        }

        public Builder enableImmersiveMode(boolean z) {
            checkNotDisposed();
            if (this.mConfig == null) {
                this.mConfig = new ZoomyConfig();
            }
            this.mConfig.setImmersiveModeEnabled(z);
            return this;
        }

        public Builder interpolator(Interpolator interpolator) {
            checkNotDisposed();
            this.mZoomInterpolator = interpolator;
            return this;
        }

        public Builder zoomListener(ZoomListener zoomListener) {
            checkNotDisposed();
            this.mZoomListener = zoomListener;
            return this;
        }

        public Builder tapListener(TapListener tapListener) {
            checkNotDisposed();
            this.mTapListener = tapListener;
            return this;
        }

        public Builder longPressListener(LongPressListener longPressListener) {
            checkNotDisposed();
            this.mLongPressListener = longPressListener;
            return this;
        }

        public Builder doubleTapListener(DoubleTapListener doubleTapListener) {
            checkNotDisposed();
            this.mdDoubleTapListener = doubleTapListener;
            return this;
        }

        public void register() {
            checkNotDisposed();
            if (this.mConfig == null) {
                this.mConfig = Zoomy.mDefaultConfig;
            }
            TargetContainer targetContainer = this.mTargetContainer;
            if (targetContainer != null) {
                View view = this.mTargetView;
                if (view != null) {
                    ZoomableTouchListener zoomableTouchListener = new ZoomableTouchListener(targetContainer, view, this.mConfig, this.mZoomInterpolator, this.mZoomListener, this.mTapListener, this.mLongPressListener, this.mdDoubleTapListener);
                    view.setOnTouchListener(zoomableTouchListener);
                    this.mDisposed = true;
                    return;
                }
                throw new IllegalArgumentException("Target view must not be null");
            }
            throw new IllegalArgumentException("Target container must not be null");
        }

        private void checkNotDisposed() {
            if (this.mDisposed) {
                throw new IllegalStateException("Builder already disposed");
            }
        }
    }

    public static void setDefaultConfig(ZoomyConfig zoomyConfig) {
        mDefaultConfig = zoomyConfig;
    }

    public static void unregister(View view) {
        view.setOnTouchListener(null);
    }
}
