package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView;

public interface IMeasureSupporter {
    int getMeasuredHeight();

    int getMeasuredWidth();

    boolean isRegistered();

    void measure(int i, int i2);

    void onItemsRemoved(RecyclerView recyclerView);

    void onSizeChanged();

    void setRegistered(boolean z);
}
