package com.beloo.widget.chipslayoutmanager.layouter;

import android.view.View;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.IScrollingController;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.anchor.IAnchorFactory;
import com.beloo.widget.chipslayoutmanager.anchor.RowsAnchorFactory;
import com.beloo.widget.chipslayoutmanager.gravity.RowGravityModifiersFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.DecoratorBreakerFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.AbstractCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.ICriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.InfiniteCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.RowsCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.placer.IPlacerFactory;
import com.beloo.widget.chipslayoutmanager.util.StateHelper;

public class RowsStateFactory implements IStateFactory {
    private ChipsLayoutManager lm;

    public int getStart() {
        return 0;
    }

    public RowsStateFactory(ChipsLayoutManager chipsLayoutManager) {
        this.lm = chipsLayoutManager;
    }

    private IOrientationStateFactory createOrientationStateFactory() {
        return this.lm.isLayoutRTL() ? new RTLRowsOrientationStateFactory() : new LTRRowsOrientationStateFactory();
    }

    public LayouterFactory createLayouterFactory(ICriteriaFactory iCriteriaFactory, IPlacerFactory iPlacerFactory) {
        IOrientationStateFactory createOrientationStateFactory = createOrientationStateFactory();
        ChipsLayoutManager chipsLayoutManager = this.lm;
        LayouterFactory layouterFactory = new LayouterFactory(chipsLayoutManager, createOrientationStateFactory.createLayouterCreator(chipsLayoutManager), new DecoratorBreakerFactory(this.lm.getViewPositionsStorage(), this.lm.getRowBreaker(), this.lm.getMaxViewsInRow(), createOrientationStateFactory.createDefaultBreaker()), iCriteriaFactory, iPlacerFactory, new RowGravityModifiersFactory(), createOrientationStateFactory.createRowStrategyFactory().createRowStrategy(this.lm.getRowStrategyType()));
        return layouterFactory;
    }

    public AbstractCriteriaFactory createDefaultFinishingCriteriaFactory() {
        return StateHelper.isInfinite(this) ? new InfiniteCriteriaFactory() : new RowsCriteriaFactory();
    }

    public IAnchorFactory anchorFactory() {
        ChipsLayoutManager chipsLayoutManager = this.lm;
        return new RowsAnchorFactory(chipsLayoutManager, chipsLayoutManager.getCanvas());
    }

    public IScrollingController scrollingController() {
        return this.lm.verticalScrollingController();
    }

    public ICanvas createCanvas() {
        return new RowSquare(this.lm);
    }

    public int getSizeMode() {
        return this.lm.getHeightMode();
    }

    public int getStart(View view) {
        return this.lm.getDecoratedTop(view);
    }

    public int getStart(AnchorViewState anchorViewState) {
        return anchorViewState.getAnchorViewRect().top;
    }

    public int getEnd() {
        return this.lm.getHeight();
    }

    public int getEnd(View view) {
        return this.lm.getDecoratedBottom(view);
    }

    public int getEnd(AnchorViewState anchorViewState) {
        return anchorViewState.getAnchorViewRect().bottom;
    }

    public int getEndViewPosition() {
        ChipsLayoutManager chipsLayoutManager = this.lm;
        return chipsLayoutManager.getPosition(chipsLayoutManager.getCanvas().getRightView());
    }

    public int getStartAfterPadding() {
        return this.lm.getPaddingTop();
    }

    public int getStartViewPosition() {
        ChipsLayoutManager chipsLayoutManager = this.lm;
        return chipsLayoutManager.getPosition(chipsLayoutManager.getCanvas().getLeftView());
    }

    public int getEndAfterPadding() {
        return this.lm.getHeight() - this.lm.getPaddingBottom();
    }

    public int getStartViewBound() {
        return getStart(this.lm.getCanvas().getTopView());
    }

    public int getEndViewBound() {
        return getEnd(this.lm.getCanvas().getBottomView());
    }

    public int getTotalSpace() {
        return (this.lm.getHeight() - this.lm.getPaddingTop()) - this.lm.getPaddingBottom();
    }
}
