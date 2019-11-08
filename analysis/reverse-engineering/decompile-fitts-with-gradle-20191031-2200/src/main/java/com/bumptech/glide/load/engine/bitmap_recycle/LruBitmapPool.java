package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Config DEFAULT_CONFIG = Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    private interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        public void add(Bitmap bitmap) {
        }

        public void remove(Bitmap bitmap) {
        }

        NullBitmapTracker() {
        }
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can't add already added bitmap: ");
            sb.append(bitmap);
            sb.append(" [");
            sb.append(bitmap.getWidth());
            sb.append("x");
            sb.append(bitmap.getHeight());
            sb.append("]");
            throw new IllegalStateException(sb.toString());
        }

        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Config> set) {
        this.initialMaxSize = j;
        this.maxSize = j;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    public LruBitmapPool(long j) {
        this(j, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long j, Set<Config> set) {
        this(j, getDefaultStrategy(), set);
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = (long) Math.round(((float) this.initialMaxSize) * f);
        evict();
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.strategy.getSize(bitmap)) <= this.maxSize) {
                        if (this.allowedConfigs.contains(bitmap.getConfig())) {
                            int size = this.strategy.getSize(bitmap);
                            this.strategy.put(bitmap);
                            this.tracker.add(bitmap);
                            this.puts++;
                            this.currentSize += (long) size;
                            if (Log.isLoggable(TAG, 2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Put bitmap in pool=");
                                sb.append(this.strategy.logBitmap(bitmap));
                                sb.toString();
                            }
                            dump();
                            evict();
                            return;
                        }
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.strategy.logBitmap(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.allowedConfigs.contains(bitmap.getConfig()));
                        sb2.toString();
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } finally {
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @NonNull
    public Bitmap get(int i, int i2, Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        if (dirtyOrNull == null) {
            return createBitmap(i, i2, config);
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    @NonNull
    public Bitmap getDirty(int i, int i2, Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i, i2, config);
        return dirtyOrNull == null ? createBitmap(i, i2, config) : dirtyOrNull;
    }

    @NonNull
    private static Bitmap createBitmap(int i, int i2, @Nullable Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Config config) {
        if (VERSION.SDK_INT >= 26 && config == Config.HARDWARE) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a mutable Bitmap with config: ");
            sb.append(config);
            sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i, int i2, @Nullable Config config) {
        Bitmap bitmap;
        assertNotHardwareConfig(config);
        bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.strategy.logBitmap(i, i2, config));
                sb.toString();
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= (long) this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            normalize(bitmap);
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.strategy.logBitmap(i, i2, config));
            sb2.toString();
        }
        dump();
        return bitmap;
    }

    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public void clearMemory() {
        boolean isLoggable = Log.isLoggable(TAG, 3);
        trimToSize(0);
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i);
            sb.toString();
        }
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    private synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= (long) this.strategy.getSize(removeLast);
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.strategy.logBitmap(removeLast));
                sb.toString();
            }
            dump();
            removeLast.recycle();
        }
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.hits);
        sb.append(", misses=");
        sb.append(this.misses);
        sb.append(", puts=");
        sb.append(this.puts);
        sb.append(", evictions=");
        sb.append(this.evictions);
        sb.append(", currentSize=");
        sb.append(this.currentSize);
        sb.append(", maxSize=");
        sb.append(this.maxSize);
        sb.append("\nStrategy=");
        sb.append(this.strategy);
        sb.toString();
    }

    private static LruPoolStrategy getDefaultStrategy() {
        if (VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    @TargetApi(26)
    private static Set<Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
