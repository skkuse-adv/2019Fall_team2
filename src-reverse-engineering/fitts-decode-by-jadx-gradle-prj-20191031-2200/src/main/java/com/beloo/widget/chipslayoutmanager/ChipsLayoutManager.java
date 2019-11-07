package com.beloo.widget.chipslayoutmanager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.State;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.anchor.IAnchorFactory;
import com.beloo.widget.chipslayoutmanager.cache.IViewCacheStorage;
import com.beloo.widget.chipslayoutmanager.cache.ViewCacheFactory;
import com.beloo.widget.chipslayoutmanager.gravity.CenterChildGravity;
import com.beloo.widget.chipslayoutmanager.gravity.CustomGravityResolver;
import com.beloo.widget.chipslayoutmanager.gravity.IChildGravityResolver;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractPositionIterator;
import com.beloo.widget.chipslayoutmanager.layouter.ColumnsStateFactory;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;
import com.beloo.widget.chipslayoutmanager.layouter.ILayouter;
import com.beloo.widget.chipslayoutmanager.layouter.IMeasureSupporter;
import com.beloo.widget.chipslayoutmanager.layouter.IStateFactory;
import com.beloo.widget.chipslayoutmanager.layouter.LayouterFactory;
import com.beloo.widget.chipslayoutmanager.layouter.MeasureSupporter;
import com.beloo.widget.chipslayoutmanager.layouter.RowsStateFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.EmptyRowBreaker;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.AbstractCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.InfiniteCriteriaFactory;
import com.beloo.widget.chipslayoutmanager.layouter.placer.PlacerFactory;
import com.beloo.widget.chipslayoutmanager.util.AssertionUtils;
import com.beloo.widget.chipslayoutmanager.util.LayoutManagerUtil;
import com.beloo.widget.chipslayoutmanager.util.log.IFillLogger;
import com.beloo.widget.chipslayoutmanager.util.log.Log;
import com.beloo.widget.chipslayoutmanager.util.log.LoggerFactory;
import com.beloo.widget.chipslayoutmanager.util.testing.EmptySpy;
import com.beloo.widget.chipslayoutmanager.util.testing.ISpy;
import java.util.Iterator;
import java.util.Locale;

public class ChipsLayoutManager extends LayoutManager implements IChipsLayoutManagerContract, IStateHolder, IScrollerListener {
    public static final int HORIZONTAL = 1;
    public static final int STRATEGY_CENTER = 5;
    public static final int STRATEGY_CENTER_DENSE = 6;
    public static final int STRATEGY_DEFAULT = 1;
    public static final int STRATEGY_FILL_SPACE = 4;
    public static final int STRATEGY_FILL_VIEW = 2;
    private static final String TAG = "ChipsLayoutManager";
    public static final int VERTICAL = 2;
    /* access modifiers changed from: private */
    public IAnchorFactory anchorFactory;
    /* access modifiers changed from: private */
    public AnchorViewState anchorView;
    @Nullable
    private Integer cacheNormalizationPosition = null;
    /* access modifiers changed from: private */
    public ICanvas canvas;
    /* access modifiers changed from: private */
    public IChildGravityResolver childGravityResolver;
    private SparseArray<View> childViewPositions = new SparseArray<>();
    /* access modifiers changed from: private */
    public ChildViewsIterable childViews = new ChildViewsIterable(this);
    private ParcelableContainer container = new ParcelableContainer();
    /* access modifiers changed from: private */
    public IDisappearingViewsManager disappearingViewsManager;
    private boolean isAfterPreLayout;
    private boolean isLayoutRTL = false;
    private boolean isScrollingEnabledContract = true;
    private boolean isSmoothScrollbarEnabled = false;
    /* access modifiers changed from: private */
    public boolean isStrategyAppliedWithLastRow;
    /* access modifiers changed from: private */
    public int layoutOrientation = 1;
    private IFillLogger logger;
    /* access modifiers changed from: private */
    public Integer maxViewsInRow = null;
    private IMeasureSupporter measureSupporter;
    private int orientation;
    private PlacerFactory placerFactory = new PlacerFactory(this);
    /* access modifiers changed from: private */
    public IRowBreaker rowBreaker = new EmptyRowBreaker();
    /* access modifiers changed from: private */
    public int rowStrategy = 1;
    /* access modifiers changed from: private */
    public IScrollingController scrollingController;
    private ISpy spy = new EmptySpy();
    /* access modifiers changed from: private */
    public IStateFactory stateFactory;
    private SparseArray<View> viewCache = new SparseArray<>();
    private IViewCacheStorage viewPositionsStorage;

    public class Builder {
        private Integer gravity;

        private Builder() {
        }

        public Builder setChildGravity(int i) {
            this.gravity = Integer.valueOf(i);
            return this;
        }

        public Builder setGravityResolver(@NonNull IChildGravityResolver iChildGravityResolver) {
            AssertionUtils.assertNotNull(iChildGravityResolver, "gravity resolver couldn't be null");
            ChipsLayoutManager.this.childGravityResolver = iChildGravityResolver;
            return this;
        }

        public Builder setScrollingEnabled(boolean z) {
            ChipsLayoutManager.this.setScrollingEnabledContract(z);
            return this;
        }

        public StrategyBuilder setRowStrategy(int i) {
            ChipsLayoutManager.this.rowStrategy = i;
            return (StrategyBuilder) this;
        }

        public Builder setMaxViewsInRow(@IntRange(from = 1) int i) {
            if (i >= 1) {
                ChipsLayoutManager.this.maxViewsInRow = Integer.valueOf(i);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxViewsInRow should be positive, but is = ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setRowBreaker(@NonNull IRowBreaker iRowBreaker) {
            AssertionUtils.assertNotNull(iRowBreaker, "breaker couldn't be null");
            ChipsLayoutManager.this.rowBreaker = iRowBreaker;
            return this;
        }

        public Builder setOrientation(int i) {
            if (i != 1 && i != 2) {
                return this;
            }
            ChipsLayoutManager.this.layoutOrientation = i;
            return this;
        }

        public ChipsLayoutManager build() {
            if (ChipsLayoutManager.this.childGravityResolver == null) {
                Integer num = this.gravity;
                if (num != null) {
                    ChipsLayoutManager.this.childGravityResolver = new CustomGravityResolver(num.intValue());
                } else {
                    ChipsLayoutManager.this.childGravityResolver = new CenterChildGravity();
                }
            }
            ChipsLayoutManager chipsLayoutManager = ChipsLayoutManager.this;
            chipsLayoutManager.stateFactory = chipsLayoutManager.layoutOrientation == 1 ? new RowsStateFactory(ChipsLayoutManager.this) : new ColumnsStateFactory(ChipsLayoutManager.this);
            ChipsLayoutManager chipsLayoutManager2 = ChipsLayoutManager.this;
            chipsLayoutManager2.canvas = chipsLayoutManager2.stateFactory.createCanvas();
            ChipsLayoutManager chipsLayoutManager3 = ChipsLayoutManager.this;
            chipsLayoutManager3.anchorFactory = chipsLayoutManager3.stateFactory.anchorFactory();
            ChipsLayoutManager chipsLayoutManager4 = ChipsLayoutManager.this;
            chipsLayoutManager4.scrollingController = chipsLayoutManager4.stateFactory.scrollingController();
            ChipsLayoutManager chipsLayoutManager5 = ChipsLayoutManager.this;
            chipsLayoutManager5.anchorView = chipsLayoutManager5.anchorFactory.createNotFound();
            ChipsLayoutManager chipsLayoutManager6 = ChipsLayoutManager.this;
            chipsLayoutManager6.disappearingViewsManager = new DisappearingViewsManager(chipsLayoutManager6.canvas, ChipsLayoutManager.this.childViews, ChipsLayoutManager.this.stateFactory);
            return ChipsLayoutManager.this;
        }
    }

    public class StrategyBuilder extends Builder {
        public StrategyBuilder() {
            super();
        }

        public Builder withLastRow(boolean z) {
            ChipsLayoutManager.this.isStrategyAppliedWithLastRow = z;
            return this;
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    @VisibleForTesting
    ChipsLayoutManager(Context context) {
        this.orientation = context.getResources().getConfiguration().orientation;
        this.logger = new LoggerFactory().getFillLogger(this.viewCache);
        this.viewPositionsStorage = new ViewCacheFactory(this).createCacheStorage();
        this.measureSupporter = new MeasureSupporter(this);
        setAutoMeasureEnabled(true);
    }

    public static Builder newBuilder(Context context) {
        if (context != null) {
            return new StrategyBuilder();
        }
        throw new IllegalArgumentException("you have passed null context to builder");
    }

    public IChildGravityResolver getChildGravityResolver() {
        return this.childGravityResolver;
    }

    public void setScrollingEnabledContract(boolean z) {
        this.isScrollingEnabledContract = z;
    }

    public boolean isScrollingEnabledContract() {
        return this.isScrollingEnabledContract;
    }

    public void setMaxViewsInRow(@IntRange(from = 1) Integer num) {
        if (num.intValue() >= 1) {
            this.maxViewsInRow = num;
            onRuntimeLayoutChanges();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("maxViewsInRow should be positive, but is = ");
        sb.append(num);
        throw new IllegalArgumentException(sb.toString());
    }

    private void onRuntimeLayoutChanges() {
        this.cacheNormalizationPosition = Integer.valueOf(0);
        this.viewPositionsStorage.purge();
        requestLayoutWithAnimations();
    }

    public Integer getMaxViewsInRow() {
        return this.maxViewsInRow;
    }

    public IRowBreaker getRowBreaker() {
        return this.rowBreaker;
    }

    public int getRowStrategyType() {
        return this.rowStrategy;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isStrategyAppliedWithLastRow() {
        return this.isStrategyAppliedWithLastRow;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public IViewCacheStorage getViewPositionsStorage() {
        return this.viewPositionsStorage;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public ICanvas getCanvas() {
        return this.canvas;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    @RestrictTo({Scope.LIBRARY_GROUP})
    public AnchorViewState getAnchor() {
        return this.anchorView;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    private void requestLayoutWithAnimations() {
        LayoutManagerUtil.requestLayoutWithAnimations(this);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.container = (ParcelableContainer) parcelable;
        this.anchorView = this.container.getAnchorViewState();
        if (this.orientation != this.container.getOrientation()) {
            int intValue = this.anchorView.getPosition().intValue();
            this.anchorView = this.anchorFactory.createNotFound();
            this.anchorView.setPosition(Integer.valueOf(intValue));
        }
        this.viewPositionsStorage.onRestoreInstanceState(this.container.getPositionsCache(this.orientation));
        this.cacheNormalizationPosition = this.container.getNormalizationPosition(this.orientation);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("RESTORE. last cache position before cleanup = ");
        sb.append(this.viewPositionsStorage.getLastCachePosition());
        Log.d(str, sb.toString());
        Integer num = this.cacheNormalizationPosition;
        if (num != null) {
            this.viewPositionsStorage.purgeCacheFromPosition(num.intValue());
        }
        this.viewPositionsStorage.purgeCacheFromPosition(this.anchorView.getPosition().intValue());
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RESTORE. anchor position =");
        sb2.append(this.anchorView.getPosition());
        Log.d(str2, sb2.toString());
        String str3 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("RESTORE. layoutOrientation = ");
        sb3.append(this.orientation);
        sb3.append(" normalizationPos = ");
        sb3.append(this.cacheNormalizationPosition);
        Log.d(str3, sb3.toString());
        String str4 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("RESTORE. last cache position = ");
        sb4.append(this.viewPositionsStorage.getLastCachePosition());
        Log.d(str4, sb4.toString());
    }

    public Parcelable onSaveInstanceState() {
        this.container.putAnchorViewState(this.anchorView);
        this.container.putPositionsCache(this.orientation, this.viewPositionsStorage.onSaveInstanceState());
        this.container.putOrientation(this.orientation);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("STORE. last cache position =");
        sb.append(this.viewPositionsStorage.getLastCachePosition());
        Log.d(str, sb.toString());
        Integer num = this.cacheNormalizationPosition;
        if (num == null) {
            num = this.viewPositionsStorage.getLastCachePosition();
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("STORE. layoutOrientation = ");
        sb2.append(this.orientation);
        sb2.append(" normalizationPos = ");
        sb2.append(num);
        Log.d(str2, sb2.toString());
        this.container.putNormalizationPosition(this.orientation, num);
        return this.container;
    }

    public int getCompletelyVisibleViewsCount() {
        Iterator it = this.childViews.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.canvas.isFullyVisible((View) it.next())) {
                i++;
            }
        }
        return i;
    }

    public int findFirstVisibleItemPosition() {
        if (getChildCount() == 0) {
            return -1;
        }
        return this.canvas.getMinPositionOnScreen().intValue();
    }

    public int findFirstCompletelyVisibleItemPosition() {
        Iterator it = this.childViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            Rect viewRect = this.canvas.getViewRect(view);
            if (this.canvas.isFullyVisible(viewRect) && this.canvas.isInside(viewRect)) {
                return getPosition(view);
            }
        }
        return -1;
    }

    public int findLastVisibleItemPosition() {
        if (getChildCount() == 0) {
            return -1;
        }
        return this.canvas.getMaxPositionOnScreen().intValue();
    }

    public int findLastCompletelyVisibleItemPosition() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.canvas.isFullyVisible(this.canvas.getViewRect(childAt)) && this.canvas.isInside(childAt)) {
                return getPosition(childAt);
            }
        }
        return -1;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public int layoutOrientation() {
        return this.layoutOrientation;
    }

    public int getItemCount() {
        return super.getItemCount() + this.disappearingViewsManager.getDeletingItemsOnScreenCount();
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        this.spy.onLayoutChildren(recycler, state);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onLayoutChildren. State =");
        sb.append(state);
        Log.d(str, sb.toString());
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isPreLayout = ");
        sb2.append(state.isPreLayout());
        Log.i("onLayoutChildren", sb2.toString(), 4);
        if (isLayoutRTL() != this.isLayoutRTL) {
            this.isLayoutRTL = isLayoutRTL();
            detachAndScrapAttachedViews(recycler);
        }
        calcRecyclerCacheSize(recycler);
        if (state.isPreLayout()) {
            int calcDisappearingViewsLength = this.disappearingViewsManager.calcDisappearingViewsLength(recycler);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("height =");
            sb3.append(getHeight());
            Log.d("LayoutManager", sb3.toString(), 4);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("additional height  = ");
            sb4.append(calcDisappearingViewsLength);
            Log.d("onDeletingHeightCalc", sb4.toString(), 4);
            this.anchorView = this.anchorFactory.getAnchor();
            this.anchorFactory.resetRowCoordinates(this.anchorView);
            String str2 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("anchor state in pre-layout = ");
            sb5.append(this.anchorView);
            Log.w(str2, sb5.toString());
            detachAndScrapAttachedViews(recycler);
            AbstractCriteriaFactory createDefaultFinishingCriteriaFactory = this.stateFactory.createDefaultFinishingCriteriaFactory();
            createDefaultFinishingCriteriaFactory.setAdditionalRowsCount(5);
            createDefaultFinishingCriteriaFactory.setAdditionalLength(calcDisappearingViewsLength);
            LayouterFactory createLayouterFactory = this.stateFactory.createLayouterFactory(createDefaultFinishingCriteriaFactory, this.placerFactory.createRealPlacerFactory());
            this.logger.onBeforeLayouter(this.anchorView);
            fill(recycler, createLayouterFactory.getBackwardLayouter(this.anchorView), createLayouterFactory.getForwardLayouter(this.anchorView));
            this.isAfterPreLayout = true;
        } else {
            detachAndScrapAttachedViews(recycler);
            this.viewPositionsStorage.purgeCacheFromPosition(this.anchorView.getPosition().intValue());
            if (this.cacheNormalizationPosition != null && this.anchorView.getPosition().intValue() <= this.cacheNormalizationPosition.intValue()) {
                this.cacheNormalizationPosition = null;
            }
            AbstractCriteriaFactory createDefaultFinishingCriteriaFactory2 = this.stateFactory.createDefaultFinishingCriteriaFactory();
            createDefaultFinishingCriteriaFactory2.setAdditionalRowsCount(5);
            LayouterFactory createLayouterFactory2 = this.stateFactory.createLayouterFactory(createDefaultFinishingCriteriaFactory2, this.placerFactory.createRealPlacerFactory());
            ILayouter backwardLayouter = createLayouterFactory2.getBackwardLayouter(this.anchorView);
            ILayouter forwardLayouter = createLayouterFactory2.getForwardLayouter(this.anchorView);
            fill(recycler, backwardLayouter, forwardLayouter);
            if (this.scrollingController.normalizeGaps(recycler, null)) {
                Log.d(TAG, "normalize gaps");
                this.anchorView = this.anchorFactory.getAnchor();
                requestLayoutWithAnimations();
            }
            if (this.isAfterPreLayout) {
                layoutDisappearingViews(recycler, backwardLayouter, forwardLayouter);
            }
            this.isAfterPreLayout = false;
        }
        this.disappearingViewsManager.reset();
        if (!state.isMeasuring()) {
            this.measureSupporter.onSizeChanged();
        }
    }

    public void detachAndScrapAttachedViews(Recycler recycler) {
        super.detachAndScrapAttachedViews(recycler);
        this.childViewPositions.clear();
    }

    private void layoutDisappearingViews(Recycler recycler, @NonNull ILayouter iLayouter, ILayouter iLayouter2) {
        LayouterFactory createLayouterFactory = this.stateFactory.createLayouterFactory(new InfiniteCriteriaFactory(), this.placerFactory.createDisappearingPlacerFactory());
        DisappearingViewsContainer disappearingViews = this.disappearingViewsManager.getDisappearingViews(recycler);
        if (disappearingViews.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("count = ");
            sb.append(disappearingViews.size());
            Log.d("disappearing views", sb.toString());
            Log.d("fill disappearing views", "");
            ILayouter buildForwardLayouter = createLayouterFactory.buildForwardLayouter(iLayouter2);
            for (int i = 0; i < disappearingViews.getForwardViews().size(); i++) {
                buildForwardLayouter.placeView(recycler.getViewForPosition(disappearingViews.getForwardViews().keyAt(i)));
            }
            buildForwardLayouter.layoutRow();
            ILayouter buildBackwardLayouter = createLayouterFactory.buildBackwardLayouter(iLayouter);
            for (int i2 = 0; i2 < disappearingViews.getBackwardViews().size(); i2++) {
                buildBackwardLayouter.placeView(recycler.getViewForPosition(disappearingViews.getBackwardViews().keyAt(i2)));
            }
            buildBackwardLayouter.layoutRow();
        }
    }

    private void fillCache() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            this.viewCache.put(getPosition(childAt), childAt);
        }
    }

    private void fill(Recycler recycler, ILayouter iLayouter, ILayouter iLayouter2) {
        int intValue = this.anchorView.getPosition().intValue();
        fillCache();
        for (int i = 0; i < this.viewCache.size(); i++) {
            detachView((View) this.viewCache.valueAt(i));
        }
        int i2 = intValue - 1;
        this.logger.onStartLayouter(i2);
        if (this.anchorView.getAnchorViewRect() != null) {
            fillWithLayouter(recycler, iLayouter, i2);
        }
        this.logger.onStartLayouter(intValue);
        fillWithLayouter(recycler, iLayouter2, intValue);
        this.logger.onAfterLayouter();
        for (int i3 = 0; i3 < this.viewCache.size(); i3++) {
            removeAndRecycleView((View) this.viewCache.valueAt(i3), recycler);
            this.logger.onRemovedAndRecycled(i3);
        }
        this.canvas.findBorderViews();
        buildChildWithPositionsMap();
        this.viewCache.clear();
        this.logger.onAfterRemovingViews();
    }

    private void buildChildWithPositionsMap() {
        this.childViewPositions.clear();
        Iterator it = this.childViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            this.childViewPositions.put(getPosition(view), view);
        }
    }

    private void fillWithLayouter(Recycler recycler, ILayouter iLayouter, int i) {
        if (i >= 0) {
            AbstractPositionIterator positionIterator = iLayouter.positionIterator();
            positionIterator.move(i);
            while (true) {
                if (!positionIterator.hasNext()) {
                    break;
                }
                int intValue = ((Integer) positionIterator.next()).intValue();
                View view = (View) this.viewCache.get(intValue);
                if (view == null) {
                    try {
                        View viewForPosition = recycler.getViewForPosition(intValue);
                        this.logger.onItemRequested();
                        if (!iLayouter.placeView(viewForPosition)) {
                            recycler.recycleView(viewForPosition);
                            this.logger.onItemRecycled();
                            break;
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                } else if (!iLayouter.onAttachView(view)) {
                    break;
                } else {
                    this.viewCache.remove(intValue);
                }
            }
            this.logger.onFinishedLayouter();
            iLayouter.layoutRow();
        }
    }

    private void calcRecyclerCacheSize(Recycler recycler) {
        Integer num = this.maxViewsInRow;
        recycler.setViewCacheSize((int) (((float) (num == null ? 10 : num.intValue())) * 2.0f));
    }

    private void performNormalizationIfNeeded() {
        if (this.cacheNormalizationPosition != null && getChildCount() > 0) {
            int position = getPosition(getChildAt(0));
            if (position < this.cacheNormalizationPosition.intValue() || (this.cacheNormalizationPosition.intValue() == 0 && this.cacheNormalizationPosition.intValue() == position)) {
                StringBuilder sb = new StringBuilder();
                sb.append("position = ");
                sb.append(this.cacheNormalizationPosition);
                sb.append(" top view position = ");
                sb.append(position);
                Log.d("normalization", sb.toString());
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cache purged from position ");
                sb2.append(position);
                Log.d(str, sb2.toString());
                this.viewPositionsStorage.purgeCacheFromPosition(position);
                this.cacheNormalizationPosition = null;
                requestLayoutWithAnimations();
            }
        }
    }

    public void setMeasuredDimension(int i, int i2) {
        this.measureSupporter.measure(i, i2);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("measured dimension = ");
        sb.append(i2);
        Log.i(str, sb.toString());
        super.setMeasuredDimension(this.measureSupporter.getMeasuredWidth(), this.measureSupporter.getMeasuredHeight());
    }

    public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        if (adapter != null && this.measureSupporter.isRegistered()) {
            try {
                this.measureSupporter.setRegistered(false);
                adapter.unregisterAdapterDataObserver((AdapterDataObserver) this.measureSupporter);
            } catch (IllegalStateException unused) {
            }
        }
        if (adapter2 != null) {
            this.measureSupporter.setRegistered(true);
            adapter2.registerAdapterDataObserver((AdapterDataObserver) this.measureSupporter);
        }
        removeAllViews();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("starts from = ");
        sb.append(i);
        sb.append(", item count = ");
        sb.append(i2);
        Log.d("onItemsRemoved", sb.toString(), 1);
        super.onItemsRemoved(recyclerView, i, i2);
        onLayoutUpdatedFromPosition(i);
        this.measureSupporter.onItemsRemoved(recyclerView);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("starts from = ");
        sb.append(i);
        sb.append(", item count = ");
        sb.append(i2);
        Log.d("onItemsAdded", sb.toString(), 1);
        super.onItemsAdded(recyclerView, i, i2);
        onLayoutUpdatedFromPosition(i);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        Log.d("onItemsChanged", "", 1);
        super.onItemsChanged(recyclerView);
        this.viewPositionsStorage.purge();
        onLayoutUpdatedFromPosition(0);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("starts from = ");
        sb.append(i);
        sb.append(", item count = ");
        sb.append(i2);
        Log.d("onItemsUpdated", sb.toString(), 1);
        super.onItemsUpdated(recyclerView, i, i2);
        onLayoutUpdatedFromPosition(i);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        onItemsUpdated(recyclerView, i, i2);
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        Log.d("onItemsMoved", String.format(Locale.US, "from = %d, to = %d, itemCount = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}), 1);
        super.onItemsMoved(recyclerView, i, i2, i3);
        onLayoutUpdatedFromPosition(Math.min(i, i2));
    }

    private void onLayoutUpdatedFromPosition(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("cache purged from position ");
        sb.append(i);
        Log.d(str, sb.toString());
        this.viewPositionsStorage.purgeCacheFromPosition(i);
        int startOfRow = this.viewPositionsStorage.getStartOfRow(i);
        Integer num = this.cacheNormalizationPosition;
        if (num != null) {
            startOfRow = Math.min(num.intValue(), startOfRow);
        }
        this.cacheNormalizationPosition = Integer.valueOf(startOfRow);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.isSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.isSmoothScrollbarEnabled;
    }

    public void scrollToPosition(int i) {
        if (i >= getItemCount() || i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot scroll to ");
            sb.append(i);
            sb.append(", item count ");
            sb.append(getItemCount());
            Log.e("span layout manager", sb.toString());
            return;
        }
        Integer lastCachePosition = this.viewPositionsStorage.getLastCachePosition();
        Integer num = this.cacheNormalizationPosition;
        if (num == null) {
            num = lastCachePosition;
        }
        this.cacheNormalizationPosition = num;
        if (lastCachePosition != null && i < lastCachePosition.intValue()) {
            i = this.viewPositionsStorage.getStartOfRow(i);
        }
        this.anchorView = this.anchorFactory.createNotFound();
        this.anchorView.setPosition(Integer.valueOf(i));
        super.requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        if (i >= getItemCount() || i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot scroll to ");
            sb.append(i);
            sb.append(", item count ");
            sb.append(getItemCount());
            Log.e("span layout manager", sb.toString());
            return;
        }
        SmoothScroller createSmoothScroller = this.scrollingController.createSmoothScroller(recyclerView.getContext(), i, 150, this.anchorView);
        createSmoothScroller.setTargetPosition(i);
        startSmoothScroll(createSmoothScroller);
    }

    public boolean canScrollHorizontally() {
        return this.scrollingController.canScrollHorizontally();
    }

    public boolean canScrollVertically() {
        return this.scrollingController.canScrollVertically();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        return this.scrollingController.scrollVerticallyBy(i, recycler, state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        return this.scrollingController.scrollHorizontallyBy(i, recycler, state);
    }

    public VerticalScrollingController verticalScrollingController() {
        return new VerticalScrollingController(this, this.stateFactory, this);
    }

    public HorizontalScrollingController horizontalScrollingController() {
        return new HorizontalScrollingController(this, this.stateFactory, this);
    }

    public void onScrolled(IScrollingController iScrollingController, Recycler recycler, State state) {
        performNormalizationIfNeeded();
        this.anchorView = this.anchorFactory.getAnchor();
        AbstractCriteriaFactory createDefaultFinishingCriteriaFactory = this.stateFactory.createDefaultFinishingCriteriaFactory();
        createDefaultFinishingCriteriaFactory.setAdditionalRowsCount(1);
        LayouterFactory createLayouterFactory = this.stateFactory.createLayouterFactory(createDefaultFinishingCriteriaFactory, this.placerFactory.createRealPlacerFactory());
        fill(recycler, createLayouterFactory.getBackwardLayouter(this.anchorView), createLayouterFactory.getForwardLayouter(this.anchorView));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollOffset(State state) {
        return this.scrollingController.computeVerticalScrollOffset(state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollExtent(State state) {
        return this.scrollingController.computeVerticalScrollExtent(state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollRange(State state) {
        return this.scrollingController.computeVerticalScrollRange(state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollExtent(State state) {
        return this.scrollingController.computeHorizontalScrollExtent(state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollOffset(State state) {
        return this.scrollingController.computeHorizontalScrollOffset(state);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollRange(State state) {
        return this.scrollingController.computeHorizontalScrollRange(state);
    }
}
