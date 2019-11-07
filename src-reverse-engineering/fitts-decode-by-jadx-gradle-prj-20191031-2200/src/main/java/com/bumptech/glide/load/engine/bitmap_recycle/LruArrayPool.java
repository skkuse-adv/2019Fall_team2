package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    private static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* access modifiers changed from: 0000 */
        public void init(int i, Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size == key.size && this.arrayClass == key.arrayClass) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.size);
            sb.append("array=");
            sb.append(this.arrayClass);
            sb.append('}');
            return sb.toString();
        }

        public void offer() {
            this.pool.offer(this);
        }

        public int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }

    private static final class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: 0000 */
        public Key get(int i, Class<?> cls) {
            Key key = (Key) get();
            key.init(i, cls);
            return key;
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    public LruArrayPool(int i) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
    }

    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    public synchronized <T> void put(T t) {
        Class cls = t.getClass();
        ArrayAdapterInterface adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            NavigableMap sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    public synchronized <T> T getExact(int i, Class<T> cls) {
        return getForKey(this.keyPool.get(i, cls), cls);
    }

    public synchronized <T> T get(int i, Class<T> cls) {
        Key key;
        Integer num = (Integer) getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
        if (mayFillRequest(i, num)) {
            key = this.keyPool.get(num.intValue(), cls);
        } else {
            key = this.keyPool.get(i, cls);
        }
        return getForKey(key, cls);
    }

    private <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface adapterFromType = getAdapterFromType(cls);
        T arrayForKey = getArrayForKey(key);
        if (arrayForKey != null) {
            this.currentSize -= adapterFromType.getArrayLength(arrayForKey) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(arrayForKey), cls);
        }
        if (arrayForKey != null) {
            return arrayForKey;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            adapterFromType.getTag();
            StringBuilder sb = new StringBuilder();
            sb.append("Allocated ");
            sb.append(key.size);
            sb.append(" bytes");
            sb.toString();
        }
        return adapterFromType.newArray(key.size);
    }

    @Nullable
    private <T> T getArrayForKey(Key key) {
        return this.groupedMap.get(key);
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8);
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    public synchronized void clearMemory() {
        evictToSize(0);
    }

    public synchronized void trimMemory(int i) {
        if (i >= 40) {
            try {
                clearMemory();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            evictToSize(this.maxSize / 2);
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            Object removeLast = this.groupedMap.removeLast();
            Preconditions.checkNotNull(removeLast);
            ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                adapterFromObject.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(adapterFromObject.getArrayLength(removeLast));
                sb.toString();
            }
        }
    }

    private void decrementArrayOfSize(int i, Class<?> cls) {
        NavigableMap sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(i);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i));
        } else {
            sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = (ArrayAdapterInterface) this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter<>();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter<>();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("No array pool found for: ");
                sb.append(cls.getSimpleName());
                throw new IllegalArgumentException(sb.toString());
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    /* access modifiers changed from: 0000 */
    public int getCurrentSize() {
        int i = 0;
        for (Class cls : this.sortedSizes.keySet()) {
            for (Integer num : ((NavigableMap) this.sortedSizes.get(cls)).keySet()) {
                i += num.intValue() * ((Integer) ((NavigableMap) this.sortedSizes.get(cls)).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return i;
    }
}
