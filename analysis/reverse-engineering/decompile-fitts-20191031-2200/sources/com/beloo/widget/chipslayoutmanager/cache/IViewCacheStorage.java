package com.beloo.widget.chipslayoutmanager.cache;

import android.graphics.Rect;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;

public interface IViewCacheStorage {
    @Nullable
    Integer getLastCachePosition();

    int getStartOfRow(int i);

    boolean isCacheEmpty();

    boolean isCachingEnabled();

    boolean isInCache(int i);

    boolean isPositionEndsRow(int i);

    boolean isPositionStartsRow(int i);

    void onRestoreInstanceState(@Nullable Parcelable parcelable);

    Parcelable onSaveInstanceState();

    void purge();

    void purgeCacheFromPosition(int i);

    void purgeCacheToPosition(int i);

    void setCachingEnabled(boolean z);

    void storeRow(List<Pair<Rect, View>> list);
}
