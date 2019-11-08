package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap bitmap;

        public void recycle() {
        }

        NonOwnedBitmapResource(@NonNull Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        @NonNull
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @NonNull
        public Bitmap get() {
            return this.bitmap;
        }

        public int getSize() {
            return Util.getBitmapByteSize(this.bitmap);
        }
    }

    public boolean handles(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }

    public Resource<Bitmap> decode(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }
}
