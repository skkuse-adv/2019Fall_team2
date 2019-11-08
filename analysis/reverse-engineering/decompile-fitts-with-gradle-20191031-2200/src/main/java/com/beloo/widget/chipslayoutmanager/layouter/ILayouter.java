package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.view.View;
import java.util.List;

public interface ILayouter {
    void addLayouterListener(ILayouterListener iLayouterListener);

    List<Item> getCurrentRowItems();

    int getPreviousRowSize();

    Rect getRowRect();

    int getRowSize();

    int getViewBottom();

    int getViewTop();

    void layoutRow();

    boolean onAttachView(View view);

    boolean placeView(View view);

    AbstractPositionIterator positionIterator();

    void removeLayouterListener(ILayouterListener iLayouterListener);
}
