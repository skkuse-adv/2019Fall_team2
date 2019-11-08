package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;

@GlideModule
public final class OkHttpLibraryGlideModule extends LibraryGlideModule {
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new Factory());
    }
}
