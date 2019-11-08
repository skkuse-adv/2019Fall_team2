package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options2) {
        this.model = Preconditions.checkNotNull(obj);
        this.signature = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.transformations = (Map) Preconditions.checkNotNull(map);
        this.resourceClass = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(options2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.model.equals(engineKey.model) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width || !this.transformations.equals(engineKey.transformations) || !this.resourceClass.equals(engineKey.resourceClass) || !this.transcodeClass.equals(engineKey.transcodeClass) || !this.options.equals(engineKey.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.model.hashCode();
            this.hashCode = (this.hashCode * 31) + this.signature.hashCode();
            this.hashCode = (this.hashCode * 31) + this.width;
            this.hashCode = (this.hashCode * 31) + this.height;
            this.hashCode = (this.hashCode * 31) + this.transformations.hashCode();
            this.hashCode = (this.hashCode * 31) + this.resourceClass.hashCode();
            this.hashCode = (this.hashCode * 31) + this.transcodeClass.hashCode();
            this.hashCode = (this.hashCode * 31) + this.options.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.model);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", resourceClass=");
        sb.append(this.resourceClass);
        sb.append(", transcodeClass=");
        sb.append(this.transcodeClass);
        sb.append(", signature=");
        sb.append(this.signature);
        sb.append(", hashCode=");
        sb.append(this.hashCode);
        sb.append(", transformations=");
        sb.append(this.transformations);
        sb.append(", options=");
        sb.append(this.options);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
