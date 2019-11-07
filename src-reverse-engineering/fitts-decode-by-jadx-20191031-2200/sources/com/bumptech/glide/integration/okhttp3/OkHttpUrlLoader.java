package com.bumptech.glide.integration.okhttp3;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.OkHttpClient;

public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    private final okhttp3.Call.Factory client;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile okhttp3.Call.Factory internalClient;
        private final okhttp3.Call.Factory client;

        public void teardown() {
        }

        private static okhttp3.Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = new OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        public Factory() {
            this(getInternalClient());
        }

        public Factory(@NonNull okhttp3.Call.Factory factory) {
            this.client = factory;
        }

        @NonNull
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }
    }

    public boolean handles(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public OkHttpUrlLoader(@NonNull okhttp3.Call.Factory factory) {
        this.client = factory;
    }

    public LoadData<InputStream> buildLoadData(@NonNull GlideUrl glideUrl, int i, int i2, @NonNull Options options) {
        return new LoadData<>(glideUrl, new OkHttpStreamFetcher(this.client, glideUrl));
    }
}
