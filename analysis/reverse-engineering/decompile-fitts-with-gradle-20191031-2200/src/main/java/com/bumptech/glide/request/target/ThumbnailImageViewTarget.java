package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    /* access modifiers changed from: protected */
    public abstract Drawable getDrawable(T t);

    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* access modifiers changed from: protected */
    public void setResource(@Nullable T t) {
        LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
        Drawable drawable = getDrawable(t);
        if (layoutParams != null) {
            int i = layoutParams.width;
            if (i > 0) {
                int i2 = layoutParams.height;
                if (i2 > 0) {
                    drawable = new FixedSizeDrawable(drawable, i, i2);
                }
            }
        }
        ((ImageView) this.view).setImageDrawable(drawable);
    }
}
