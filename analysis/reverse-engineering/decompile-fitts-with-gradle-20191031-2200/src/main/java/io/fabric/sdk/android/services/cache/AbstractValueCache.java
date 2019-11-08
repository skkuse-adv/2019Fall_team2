package io.fabric.sdk.android.services.cache;

import android.content.Context;

public abstract class AbstractValueCache<T> implements ValueCache<T> {
    private final ValueCache<T> childCache;

    /* access modifiers changed from: protected */
    public abstract void cacheValue(Context context, T t);

    /* access modifiers changed from: protected */
    public abstract void doInvalidate(Context context);

    /* access modifiers changed from: protected */
    public abstract T getCached(Context context);

    public AbstractValueCache() {
        this(null);
    }

    public AbstractValueCache(ValueCache<T> valueCache) {
        this.childCache = valueCache;
    }

    public final synchronized T get(Context context, ValueLoader<T> valueLoader) throws Exception {
        T cached;
        cached = getCached(context);
        if (cached == null) {
            cached = this.childCache != null ? this.childCache.get(context, valueLoader) : valueLoader.load(context);
            cache(context, cached);
        }
        return cached;
    }

    public final synchronized void invalidate(Context context) {
        doInvalidate(context);
    }

    private void cache(Context context, T t) {
        if (t != null) {
            cacheValue(context, t);
            return;
        }
        throw new NullPointerException();
    }
}
