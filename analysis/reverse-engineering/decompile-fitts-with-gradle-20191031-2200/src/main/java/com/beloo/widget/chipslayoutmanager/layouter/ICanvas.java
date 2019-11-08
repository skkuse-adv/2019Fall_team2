package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.view.View;
import com.beloo.widget.chipslayoutmanager.IBorder;

public interface ICanvas extends IBorder {
    void findBorderViews();

    View getBottomView();

    Rect getCanvasRect();

    View getLeftView();

    Integer getMaxPositionOnScreen();

    Integer getMinPositionOnScreen();

    View getRightView();

    View getTopView();

    Rect getViewRect(View view);

    boolean isFirstItemAdded();

    boolean isFullyVisible(Rect rect);

    boolean isFullyVisible(View view);

    boolean isInside(Rect rect);

    boolean isInside(View view);
}
