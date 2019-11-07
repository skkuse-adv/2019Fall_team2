package com.beloo.widget.chipslayoutmanager.layouter.placer;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class DisappearingPlacerFactory implements IPlacerFactory {
    private LayoutManager layoutManager;

    DisappearingPlacerFactory(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public IPlacer getAtStartPlacer() {
        return new DisappearingViewAtStartPlacer(this.layoutManager);
    }

    public IPlacer getAtEndPlacer() {
        return new DisappearingViewAtEndPlacer(this.layoutManager);
    }
}
