package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcherGenerator, DataCallback<Object> {
    private File cacheFile;
    private final FetcherReadyCallback cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    public boolean startNext() {
        List cacheKeys = this.helper.getCacheKeys();
        boolean z = false;
        if (cacheKeys.isEmpty()) {
            return false;
        }
        List registeredResourceClasses = this.helper.getRegisteredResourceClasses();
        if (!registeredResourceClasses.isEmpty()) {
            while (true) {
                if (this.modelLoaders == null || !hasNextModelLoader()) {
                    this.resourceClassIndex++;
                    if (this.resourceClassIndex >= registeredResourceClasses.size()) {
                        this.sourceIdIndex++;
                        if (this.sourceIdIndex >= cacheKeys.size()) {
                            return false;
                        }
                        this.resourceClassIndex = 0;
                    }
                    Key key = (Key) cacheKeys.get(this.sourceIdIndex);
                    Class cls = (Class) registeredResourceClasses.get(this.resourceClassIndex);
                    Key key2 = key;
                    ResourceCacheKey resourceCacheKey = new ResourceCacheKey(this.helper.getArrayPool(), key2, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(cls), cls, this.helper.getOptions());
                    this.currentKey = resourceCacheKey;
                    this.cacheFile = this.helper.getDiskCache().get(this.currentKey);
                    File file = this.cacheFile;
                    if (file != null) {
                        this.sourceKey = key;
                        this.modelLoaders = this.helper.getModelLoaders(file);
                        this.modelLoaderIndex = 0;
                    }
                } else {
                    this.loadData = null;
                    while (!z && hasNextModelLoader()) {
                        List<ModelLoader<File, ?>> list = this.modelLoaders;
                        int i = this.modelLoaderIndex;
                        this.modelLoaderIndex = i + 1;
                        this.loadData = ((ModelLoader) list.get(i)).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                        if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                            this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.helper.getTranscodeClass())) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any load path from ");
            sb.append(this.helper.getModelClass());
            sb.append(" to ");
            sb.append(this.helper.getTranscodeClass());
            throw new IllegalStateException(sb.toString());
        }
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    public void cancel() {
        LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
