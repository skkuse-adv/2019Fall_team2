package com.beloo.widget.chipslayoutmanager.layouter;

import android.view.View;
import com.beloo.widget.chipslayoutmanager.IScrollingController;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.anchor.IAnchorFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.AbstractCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.ICriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.placer.IPlacerFactory;

public interface IStateFactory {
    IAnchorFactory anchorFactory();

    ICanvas createCanvas();

    AbstractCriteriaFactory createDefaultFinishingCriteriaFactory();

    LayouterFactory createLayouterFactory(ICriteriaFactory iCriteriaFactory, IPlacerFactory iPlacerFactory);

    int getEnd();

    int getEnd(View view);

    int getEnd(AnchorViewState anchorViewState);

    int getEndAfterPadding();

    int getEndViewBound();

    int getEndViewPosition();

    int getSizeMode();

    int getStart();

    int getStart(View view);

    int getStart(AnchorViewState anchorViewState);

    int getStartAfterPadding();

    int getStartViewBound();

    int getStartViewPosition();

    int getTotalSpace();

    IScrollingController scrollingController();
}
