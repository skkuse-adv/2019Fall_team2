package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    private static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File file;

        public void cancel() {
        }

        public void cleanup() {
        }

        ByteBufferFetcher(File file2) {
            this.file = file2;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.onDataReady(ByteBufferUtil.fromFile(this.file));
            } catch (IOException e) {
                boolean isLoggable = Log.isLoggable(ByteBufferFileLoader.TAG, 3);
                dataCallback.onLoadFailed(e);
            }
        }

        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public void teardown() {
        }

        @NonNull
        public ModelLoader<File, ByteBuffer> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    public boolean handles(@NonNull File file) {
        return true;
    }

    public LoadData<ByteBuffer> buildLoadData(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(file), new ByteBufferFetcher(file));
    }
}
