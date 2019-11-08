package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements BitmapProvider {
    @Nullable
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool2) {
        this(bitmapPool2, null);
    }

    public GifBitmapProvider(BitmapPool bitmapPool2, @Nullable ArrayPool arrayPool2) {
        this.bitmapPool = bitmapPool2;
        this.arrayPool = arrayPool2;
    }

    @NonNull
    public Bitmap obtain(int i, int i2, @NonNull Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    public void release(@NonNull Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    @NonNull
    public byte[] obtainByteArray(int i) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool2.get(i, byte[].class);
    }

    public void release(@NonNull byte[] bArr) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 != null) {
            arrayPool2.put(bArr);
        }
    }

    @NonNull
    public int[] obtainIntArray(int i) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 == null) {
            return new int[i];
        }
        return (int[]) arrayPool2.get(i, int[].class);
    }

    public void release(@NonNull int[] iArr) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 != null) {
            arrayPool2.put(iArr);
        }
    }
}
