package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_LIMIT = 5242880;
    private final RecyclableBufferedInputStream bufferedStream;

    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<InputStream> {
        private final ArrayPool byteArrayPool;

        public Factory(ArrayPool arrayPool) {
            this.byteArrayPool = arrayPool;
        }

        @NonNull
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.byteArrayPool);
        }

        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        this.bufferedStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.bufferedStream.mark(MARK_LIMIT);
    }

    @NonNull
    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }

    public void cleanup() {
        this.bufferedStream.release();
    }
}
