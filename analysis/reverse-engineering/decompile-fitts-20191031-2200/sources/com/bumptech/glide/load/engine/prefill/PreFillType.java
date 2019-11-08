package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

public final class PreFillType {
    @VisibleForTesting
    static final Config DEFAULT_CONFIG = Config.RGB_565;
    private final Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i2 > 0) {
                this.width = i;
                this.height = i2;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }

        public Builder setConfig(@Nullable Config config2) {
            this.config = config2;
            return this;
        }

        /* access modifiers changed from: 0000 */
        public Config getConfig() {
            return this.config;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.weight = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        /* access modifiers changed from: 0000 */
        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
    }

    PreFillType(int i, int i2, Config config2, int i3) {
        this.config = (Config) Preconditions.checkNotNull(config2, "Config must not be null");
        this.width = i;
        this.height = i2;
        this.weight = i3;
    }

    /* access modifiers changed from: 0000 */
    public int getWidth() {
        return this.width;
    }

    /* access modifiers changed from: 0000 */
    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: 0000 */
    public Config getConfig() {
        return this.config;
    }

    /* access modifiers changed from: 0000 */
    public int getWeight() {
        return this.weight;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreFillSize{width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", config=");
        sb.append(this.config);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append('}');
        return sb.toString();
    }
}
