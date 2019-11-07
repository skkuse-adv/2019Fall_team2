package com.beloo.widget.chipslayoutmanager.layouter.placer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class DisappearingViewAtEndPlacer extends AbstractPlacer {
    DisappearingViewAtEndPlacer(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public void addView(View view) {
        getLayoutManager().addDisappearingView(view);
    }
}
