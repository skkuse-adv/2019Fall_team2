package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    private final Converter<Data> converter;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        public void teardown() {
        }

        @NonNull
        public ModelLoader<byte[], ByteBuffer> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() {
                public ByteBuffer convert(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                public Class<ByteBuffer> getDataClass() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    public interface Converter<Data> {
        Data convert(byte[] bArr);

        Class<Data> getDataClass();
    }

    private static class Fetcher<Data> implements DataFetcher<Data> {
        private final Converter<Data> converter;
        private final byte[] model;

        public void cancel() {
        }

        public void cleanup() {
        }

        Fetcher(byte[] bArr, Converter<Data> converter2) {
            this.model = bArr;
            this.converter = converter2;
        }

        public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super Data> dataCallback) {
            dataCallback.onDataReady(this.converter.convert(this.model));
        }

        @NonNull
        public Class<Data> getDataClass() {
            return this.converter.getDataClass();
        }

        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        public void teardown() {
        }

        @NonNull
        public ModelLoader<byte[], InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() {
                public InputStream convert(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                public Class<InputStream> getDataClass() {
                    return InputStream.class;
                }
            });
        }
    }

    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }

    public ByteArrayLoader(Converter<Data> converter2) {
        this.converter = converter2;
    }

    public LoadData<Data> buildLoadData(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(bArr), new Fetcher(bArr, this.converter));
    }
}
