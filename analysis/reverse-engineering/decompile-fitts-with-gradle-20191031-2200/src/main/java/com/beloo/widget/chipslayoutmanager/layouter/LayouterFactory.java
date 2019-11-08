package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.cache.IViewCacheStorage;
import com.beloo.widget.chipslayoutmanager.gravity.IGravityModifiersFactory;
import com.beloo.widget.chipslayoutmanager.gravity.IRowStrategy;
import com.beloo.widget.chipslayoutmanager.gravity.SkipLastRowStrategy;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IBreakerFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.ICriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.placer.IPlacerFactory;
import java.util.ArrayList;
import java.util.List;

public class LayouterFactory {
    private IBreakerFactory breakerFactory;
    private IViewCacheStorage cacheStorage;
    private ICriteriaFactory criteriaFactory;
    private IGravityModifiersFactory gravityModifiersFactory;
    private ChipsLayoutManager layoutManager;
    private ILayouterCreator layouterCreator;
    private List<ILayouterListener> layouterListeners = new ArrayList();
    private IPlacerFactory placerFactory;
    private IRowStrategy rowStrategy;

    LayouterFactory(ChipsLayoutManager chipsLayoutManager, ILayouterCreator iLayouterCreator, IBreakerFactory iBreakerFactory, ICriteriaFactory iCriteriaFactory, IPlacerFactory iPlacerFactory, IGravityModifiersFactory iGravityModifiersFactory, IRowStrategy iRowStrategy) {
        this.layouterCreator = iLayouterCreator;
        this.cacheStorage = chipsLayoutManager.getViewPositionsStorage();
        this.layoutManager = chipsLayoutManager;
        this.breakerFactory = iBreakerFactory;
        this.criteriaFactory = iCriteriaFactory;
        this.placerFactory = iPlacerFactory;
        this.gravityModifiersFactory = iGravityModifiersFactory;
        this.rowStrategy = iRowStrategy;
    }

    public void addLayouterListener(@Nullable ILayouterListener iLayouterListener) {
        if (iLayouterListener != null) {
            this.layouterListeners.add(iLayouterListener);
        }
    }

    private Builder createBackwardBuilder() {
        return this.layouterCreator.createBackwardBuilder();
    }

    private Builder createForwardBuilder() {
        return this.layouterCreator.createForwardBuilder();
    }

    private Rect createOffsetRectForBackwardLayouter(@NonNull AnchorViewState anchorViewState) {
        return this.layouterCreator.createOffsetRectForBackwardLayouter(anchorViewState);
    }

    private Rect createOffsetRectForForwardLayouter(AnchorViewState anchorViewState) {
        return this.layouterCreator.createOffsetRectForForwardLayouter(anchorViewState);
    }

    private ICanvas createCanvas() {
        return this.layoutManager.getCanvas();
    }

    @NonNull
    private Builder fillBasicBuilder(Builder builder) {
        return builder.layoutManager(this.layoutManager).canvas(createCanvas()).childGravityResolver(this.layoutManager.getChildGravityResolver()).cacheStorage(this.cacheStorage).gravityModifiersFactory(this.gravityModifiersFactory).addLayouterListeners(this.layouterListeners);
    }

    @Nullable
    public final ILayouter getBackwardLayouter(@NonNull AnchorViewState anchorViewState) {
        return fillBasicBuilder(createBackwardBuilder()).offsetRect(createOffsetRectForBackwardLayouter(anchorViewState)).breaker(this.breakerFactory.createBackwardRowBreaker()).finishingCriteria(this.criteriaFactory.getBackwardFinishingCriteria()).rowStrategy(this.rowStrategy).placer(this.placerFactory.getAtStartPlacer()).positionIterator(new DecrementalPositionIterator(this.layoutManager.getItemCount())).build();
    }

    @NonNull
    public final ILayouter getForwardLayouter(@NonNull AnchorViewState anchorViewState) {
        return fillBasicBuilder(createForwardBuilder()).offsetRect(createOffsetRectForForwardLayouter(anchorViewState)).breaker(this.breakerFactory.createForwardRowBreaker()).finishingCriteria(this.criteriaFactory.getForwardFinishingCriteria()).rowStrategy(new SkipLastRowStrategy(this.rowStrategy, !this.layoutManager.isStrategyAppliedWithLastRow())).placer(this.placerFactory.getAtEndPlacer()).positionIterator(new IncrementalPositionIterator(this.layoutManager.getItemCount())).build();
    }

    @NonNull
    public final ILayouter buildForwardLayouter(@NonNull ILayouter iLayouter) {
        AbstractLayouter abstractLayouter = (AbstractLayouter) iLayouter;
        abstractLayouter.setFinishingCriteria(this.criteriaFactory.getForwardFinishingCriteria());
        abstractLayouter.setPlacer(this.placerFactory.getAtEndPlacer());
        return abstractLayouter;
    }

    @NonNull
    public final ILayouter buildBackwardLayouter(@NonNull ILayouter iLayouter) {
        AbstractLayouter abstractLayouter = (AbstractLayouter) iLayouter;
        abstractLayouter.setFinishingCriteria(this.criteriaFactory.getBackwardFinishingCriteria());
        abstractLayouter.setPlacer(this.placerFactory.getAtStartPlacer());
        return abstractLayouter;
    }
}
