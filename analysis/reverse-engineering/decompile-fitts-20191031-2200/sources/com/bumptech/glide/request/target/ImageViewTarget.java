package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements ViewAdapter {
    @Nullable
    private Animatable animatable;

    /* access modifiers changed from: protected */
    public abstract void setResource(@Nullable Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
        setResourceInternal(null);
        setDrawable(drawable);
    }

    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z, this)) {
            setResourceInternal(z);
        } else {
            maybeUpdateAnimatable(z);
        }
    }

    public void onStart() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    public void onStop() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
    }

    private void setResourceInternal(@Nullable Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    private void maybeUpdateAnimatable(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.animatable = (Animatable) z;
            this.animatable.start();
            return;
        }
        this.animatable = null;
    }
}
