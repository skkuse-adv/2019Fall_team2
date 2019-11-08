package com.beloo.widget.chipslayoutmanager.layouter.placer;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;

public class PlacerFactory {
    private ChipsLayoutManager lm;

    public PlacerFactory(ChipsLayoutManager chipsLayoutManager) {
        this.lm = chipsLayoutManager;
    }

    public IPlacerFactory createRealPlacerFactory() {
        return new RealPlacerFactory(this.lm);
    }

    public IPlacerFactory createDisappearingPlacerFactory() {
        return new DisappearingPlacerFactory(this.lm);
    }
}
