package com.beloo.widget.chipslayoutmanager.util.testing;

import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;

public interface ISpy {
    void onLayoutChildren(Recycler recycler, State state);
}
