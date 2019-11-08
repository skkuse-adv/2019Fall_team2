package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @NonNull
    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    public int getSize() {
        return ((GifDrawable) this.drawable).getSize();
    }

    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }

    public void initialize() {
        ((GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }
}
