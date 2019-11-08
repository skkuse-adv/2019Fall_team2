package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(DEFAULT_DURATION_MS);
        }

        public Builder(int i) {
            this.durationMillis = i;
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.isCrossFadeEnabled = z;
            return this;
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    public Transition<Drawable> build(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.get() : getResourceTransition();
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }
}
