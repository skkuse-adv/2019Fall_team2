package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = new LruCache<>(50);
    private final ArrayPool arrayPool;
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    ResourceCacheKey(ArrayPool arrayPool2, Key key, Key key2, int i, int i2, Transformation<?> transformation2, Class<?> cls, Options options2) {
        this.arrayPool = arrayPool2;
        this.sourceKey = key;
        this.signature = key2;
        this.width = i;
        this.height = i2;
        this.transformation = transformation2;
        this.decodedResourceClass = cls;
        this.options = options2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        if (this.height != resourceCacheKey.height || this.width != resourceCacheKey.width || !Util.bothNullOrEqual(this.transformation, resourceCacheKey.transformation) || !this.decodedResourceClass.equals(resourceCacheKey.decodedResourceClass) || !this.sourceKey.equals(resourceCacheKey.sourceKey) || !this.signature.equals(resourceCacheKey.signature) || !this.options.equals(resourceCacheKey.options)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        Transformation<?> transformation2 = this.transformation;
        if (transformation2 != null) {
            hashCode = (hashCode * 31) + transformation2.hashCode();
        }
        return (((hashCode * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation2 = this.transformation;
        if (transformation2 != null) {
            transformation2.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(getResourceClassBytes());
        this.arrayPool.put(bArr);
    }

    private byte[] getResourceClassBytes() {
        byte[] bArr = (byte[]) RESOURCE_CLASS_BYTES.get(this.decodedResourceClass);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.decodedResourceClass.getName().getBytes(Key.CHARSET);
        RESOURCE_CLASS_BYTES.put(this.decodedResourceClass, bytes);
        return bytes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.sourceKey);
        sb.append(", signature=");
        sb.append(this.signature);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", decodedResourceClass=");
        sb.append(this.decodedResourceClass);
        sb.append(", transformation='");
        sb.append(this.transformation);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.options);
        sb.append('}');
        return sb.toString();
    }
}
