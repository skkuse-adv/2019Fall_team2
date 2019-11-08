package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    public long getMaxSize() {
        return 0;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    @NonNull
    public Bitmap get(int i, int i2, Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @NonNull
    public Bitmap getDirty(int i, int i2, Config config) {
        return get(i, i2, config);
    }
}
