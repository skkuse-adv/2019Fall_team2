package com.beloo.widget.chipslayoutmanager.layouter.placer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class RealAtEndPlacer extends AbstractPlacer implements IPlacer {
    RealAtEndPlacer(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public void addView(View view) {
        getLayoutManager().addView(view);
    }
}
