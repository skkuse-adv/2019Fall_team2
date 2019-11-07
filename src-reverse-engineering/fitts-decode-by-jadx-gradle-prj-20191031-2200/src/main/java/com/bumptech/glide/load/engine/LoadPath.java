package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.listPool = pool;
        this.decodePaths = (List) Preconditions.checkNotEmpty(list);
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(cls.getSimpleName());
        String str = "->";
        sb.append(str);
        sb.append(cls2.getSimpleName());
        sb.append(str);
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.failureMessage = sb.toString();
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            Resource<Transcode> loadWithExceptionList = loadWithExceptionList(dataRewinder, options, i, i2, decodeCallback, list);
            return loadWithExceptionList;
        } finally {
            this.listPool.release(list);
        }
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.decodePaths.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = ((DecodePath) this.decodePaths.get(i3)).decode(dataRewinder, i, i2, options, decodeCallback);
            } catch (GlideException e) {
                list2.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList<Throwable>(list2));
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.decodePaths.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
