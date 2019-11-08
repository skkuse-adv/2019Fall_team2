package com.bumptech.glide;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements OnScrollListener {
    private boolean isIncreasing = true;
    private int lastEnd;
    private int lastFirstVisible = -1;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t, int i, int i2);
    }

    private static final class PreloadTarget extends BaseTarget<Object> {
        int photoHeight;
        int photoWidth;

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        PreloadTarget() {
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }
    }

    private static final class PreloadTargetQueue {
        private final Queue<PreloadTarget> queue;

        PreloadTargetQueue(int i) {
            this.queue = Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i, int i2) {
            PreloadTarget preloadTarget = (PreloadTarget) this.queue.poll();
            this.queue.offer(preloadTarget);
            preloadTarget.photoWidth = i;
            preloadTarget.photoHeight = i2;
            return preloadTarget;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public ListPreloader(@NonNull RequestManager requestManager2, @NonNull PreloadModelProvider<T> preloadModelProvider2, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.requestManager = requestManager2;
        this.preloadModelProvider = preloadModelProvider2;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new PreloadTargetQueue(i + 1);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.totalItemCount = i3;
        int i4 = this.lastFirstVisible;
        if (i > i4) {
            preload(i2 + i, true);
        } else if (i < i4) {
            preload(i, false);
        }
        this.lastFirstVisible = i;
    }

    private void preload(int i, boolean z) {
        if (this.isIncreasing != z) {
            this.isIncreasing = z;
            cancelAll();
        }
        preload(i, (z ? this.maxPreload : -this.maxPreload) + i);
    }

    private void preload(int i, int i2) {
        int i3;
        int i4;
        if (i < i2) {
            i3 = Math.max(this.lastEnd, i);
            i4 = i2;
        } else {
            i4 = Math.min(this.lastStart, i);
            i3 = i2;
        }
        int min = Math.min(this.totalItemCount, i4);
        int min2 = Math.min(this.totalItemCount, Math.max(0, i3));
        if (i < i2) {
            for (int i5 = min2; i5 < min; i5++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i5), i5, true);
            }
        } else {
            for (int i6 = min - 1; i6 >= min2; i6--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i6), i6, false);
            }
        }
        this.lastStart = min2;
        this.lastEnd = min;
    }

    private void preloadAdapterPosition(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                preloadItem(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            preloadItem(list.get(i3), i, i3);
        }
    }

    private void preloadItem(@Nullable T t, int i, int i2) {
        if (t != null) {
            int[] preloadSize = this.preloadDimensionProvider.getPreloadSize(t, i, i2);
            if (preloadSize != null) {
                RequestBuilder preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t);
                if (preloadRequestBuilder != null) {
                    preloadRequestBuilder.into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
                }
            }
        }
    }

    private void cancelAll() {
        for (int i = 0; i < this.maxPreload; i++) {
            this.requestManager.clear((Target<?>) this.preloadTargetQueue.next(0, 0));
        }
    }
}
