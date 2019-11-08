package com.beloo.widget.chipslayoutmanager.layouter.placer;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class RealPlacerFactory implements IPlacerFactory {
    private LayoutManager layoutManager;

    RealPlacerFactory(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public IPlacer getAtStartPlacer() {
        return new RealAtStartPlacer(this.layoutManager);
    }

    public IPlacer getAtEndPlacer() {
        return new RealAtEndPlacer(this.layoutManager);
    }
}
