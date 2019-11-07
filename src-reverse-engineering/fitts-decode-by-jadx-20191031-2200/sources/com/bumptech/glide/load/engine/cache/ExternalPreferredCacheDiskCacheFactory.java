package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, long j) {
        super((CacheDirectoryGetter) new CacheDirectoryGetter() {
            @Nullable
            private File getInternalCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str = str;
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            public File getCacheDirectory() {
                File internalCacheDirectory = getInternalCacheDirectory();
                if (internalCacheDirectory != null && internalCacheDirectory.exists()) {
                    return internalCacheDirectory;
                }
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null || !externalCacheDir.canWrite()) {
                    return internalCacheDirectory;
                }
                String str = str;
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, j);
    }
}
