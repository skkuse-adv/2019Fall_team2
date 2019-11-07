package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    static class UntrustedCallbacks implements DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionCatchingInputStream exceptionStream;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionCatchingInputStream;
        }

        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException exception = this.exceptionStream.getException();
            if (exception != null) {
                if (bitmap != null) {
                    bitmapPool.put(bitmap);
                }
                throw exception;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler2, ArrayPool arrayPool) {
        this.downsampler = downsampler2;
        this.byteArrayPool = arrayPool;
    }

    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.downsampler.handles(inputStream);
    }

    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
            z = true;
        }
        ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.downsampler.decode(new MarkEnforcingInputStream(obtain), i, i2, options, new UntrustedCallbacks(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }
}
