package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader<URL, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> glideUrlLoader;

    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        public void teardown() {
        }

        @NonNull
        public ModelLoader<URL, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }
    }

    public boolean handles(@NonNull URL url) {
        return true;
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    public LoadData<InputStream> buildLoadData(@NonNull URL url, int i, int i2, @NonNull Options options) {
        return this.glideUrlLoader.buildLoadData(new GlideUrl(url), i, i2, options);
    }
}
