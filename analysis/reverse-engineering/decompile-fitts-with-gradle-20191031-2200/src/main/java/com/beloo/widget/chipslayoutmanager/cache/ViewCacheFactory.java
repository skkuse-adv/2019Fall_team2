package com.beloo.widget.chipslayoutmanager.cache;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class ViewCacheFactory {
    private LayoutManager layoutManager;

    public ViewCacheFactory(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public IViewCacheStorage createCacheStorage() {
        return new ViewCacheStorage(this.layoutManager);
    }
}
