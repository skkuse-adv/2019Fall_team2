package com.beloo.widget.chipslayoutmanager.layouter.placer;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

abstract class AbstractPlacer implements IPlacer {
    private LayoutManager layoutManager;

    AbstractPlacer(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public LayoutManager getLayoutManager() {
        return this.layoutManager;
    }
}
