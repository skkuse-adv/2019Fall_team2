package com.beloo.widget.chipslayoutmanager.layouter.placer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class RealAtStartPlacer extends AbstractPlacer implements IPlacer {
    RealAtStartPlacer(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public void addView(View view) {
        getLayoutManager().addView(view, 0);
    }
}
