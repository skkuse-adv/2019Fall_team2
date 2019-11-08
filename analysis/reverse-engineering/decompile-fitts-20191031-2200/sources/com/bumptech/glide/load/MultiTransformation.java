package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.transformations = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.transformations = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @NonNull
    public Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation transform : this.transformations) {
            Resource<T> transform2 = transform.transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform2)) {
                resource2.recycle();
            }
            resource2 = transform2;
        }
        return resource2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MultiTransformation)) {
            return false;
        }
        return this.transformations.equals(((MultiTransformation) obj).transformations);
    }

    public int hashCode() {
        return this.transformations.hashCode();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (Transformation updateDiskCacheKey : this.transformations) {
            updateDiskCacheKey.updateDiskCacheKey(messageDigest);
        }
    }
}
