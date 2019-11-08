package com.beloo.widget.chipslayoutmanager.cache;

import android.graphics.Rect;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class ViewCacheStorage implements IViewCacheStorage {
    private NavigableSet<Integer> endsRow = new TreeSet();
    private boolean isCachingEnabled;
    private LayoutManager layoutManager;
    private int maxCacheSize = 1000;
    private NavigableSet<Integer> startsRow = new TreeSet();

    ViewCacheStorage(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
        this.isCachingEnabled = true;
    }

    public void setMaxCacheSize(int i) {
        this.maxCacheSize = i;
    }

    public boolean isCachingEnabled() {
        return this.isCachingEnabled;
    }

    public int getStartOfRow(int i) {
        Integer num = (Integer) this.startsRow.floor(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(i);
        }
        return num.intValue();
    }

    public boolean isPositionEndsRow(int i) {
        return this.endsRow.contains(Integer.valueOf(i));
    }

    public boolean isPositionStartsRow(int i) {
        return this.startsRow.contains(Integer.valueOf(i));
    }

    public void setCachingEnabled(boolean z) {
        if (this.isCachingEnabled != z) {
            this.isCachingEnabled = z;
        }
    }

    private void checkCacheSizeReached() {
        if (this.startsRow.size() > this.maxCacheSize) {
            NavigableSet<Integer> navigableSet = this.startsRow;
            navigableSet.remove(navigableSet.first());
        }
        if (this.endsRow.size() > this.maxCacheSize) {
            NavigableSet<Integer> navigableSet2 = this.endsRow;
            navigableSet2.remove(navigableSet2.first());
        }
    }

    public void storeRow(List<Pair<Rect, View>> list) {
        if (this.isCachingEnabled && !list.isEmpty()) {
            Pair pair = (Pair) list.get(0);
            Pair pair2 = (Pair) list.get(list.size() - 1);
            int position = this.layoutManager.getPosition((View) pair.second);
            int position2 = this.layoutManager.getPosition((View) pair2.second);
            checkCacheSizeReached();
            this.startsRow.add(Integer.valueOf(position));
            this.endsRow.add(Integer.valueOf(position2));
        }
    }

    public boolean isInCache(int i) {
        return (this.startsRow.ceiling(Integer.valueOf(i)) == null && this.endsRow.ceiling(Integer.valueOf(i)) == null) ? false : true;
    }

    public void purge() {
        this.startsRow.clear();
        this.endsRow.clear();
    }

    public void purgeCacheToPosition(int i) {
        if (!isCacheEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("cache purged to position ");
            sb.append(i);
            sb.toString();
            Iterator it = this.startsRow.headSet(Integer.valueOf(i)).iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            Iterator it2 = this.endsRow.headSet(Integer.valueOf(i)).iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        }
    }

    public Integer getLastCachePosition() {
        if (isCacheEmpty()) {
            return null;
        }
        return (Integer) this.endsRow.last();
    }

    public boolean isCacheEmpty() {
        return this.endsRow.isEmpty();
    }

    public void purgeCacheFromPosition(int i) {
        if (!isCacheEmpty()) {
            Iterator it = this.startsRow.tailSet(Integer.valueOf(i), true).iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            Integer num = (Integer) this.startsRow.lower(Integer.valueOf(i));
            if (num != null) {
                i = num.intValue();
            }
            Iterator it2 = this.endsRow.tailSet(Integer.valueOf(i), true).iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        return new CacheParcelableContainer(this.startsRow, this.endsRow);
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable instanceof CacheParcelableContainer) {
                CacheParcelableContainer cacheParcelableContainer = (CacheParcelableContainer) parcelable;
                this.startsRow = cacheParcelableContainer.getStartsRow();
                this.endsRow = cacheParcelableContainer.getEndsRow();
                return;
            }
            throw new IllegalStateException("wrong parcelable passed");
        }
    }
}
