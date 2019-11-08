package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.IBorder;
import com.beloo.widget.chipslayoutmanager.cache.IViewCacheStorage;
import com.beloo.widget.chipslayoutmanager.gravity.IChildGravityResolver;
import com.beloo.widget.chipslayoutmanager.gravity.IGravityModifiersFactory;
import com.beloo.widget.chipslayoutmanager.gravity.IRowStrategy;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.ILayoutRowBreaker;
import com.beloo.widget.chipslayoutmanager.layouter.criteria.IFinishingCriteria;
import com.beloo.widget.chipslayoutmanager.layouter.placer.IPlacer;
import com.beloo.widget.chipslayoutmanager.util.AssertionUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class AbstractLayouter implements ILayouter, IBorder {
    @NonNull
    private IBorder border;
    @NonNull
    private ILayoutRowBreaker breaker;
    @NonNull
    private IViewCacheStorage cacheStorage;
    @NonNull
    private IChildGravityResolver childGravityResolver;
    private int currentViewHeight;
    private int currentViewPosition;
    private int currentViewWidth;
    @NonNull
    private IFinishingCriteria finishingCriteria;
    @NonNull
    private IGravityModifiersFactory gravityModifiersFactory;
    private boolean isRowCompleted;
    @NonNull
    private ChipsLayoutManager layoutManager;
    private Set<ILayouterListener> layouterListeners = new HashSet();
    @NonNull
    private IPlacer placer;
    @NonNull
    private AbstractPositionIterator positionIterator;
    private int previousRowSize;
    private int rowSize = 0;
    @NonNull
    private IRowStrategy rowStrategy;
    List<Pair<Rect, View>> rowViews = new LinkedList();
    int viewBottom;
    int viewLeft;
    int viewRight;
    int viewTop;

    public static abstract class Builder {
        /* access modifiers changed from: private */
        public IBorder border;
        /* access modifiers changed from: private */
        public ILayoutRowBreaker breaker;
        /* access modifiers changed from: private */
        public IViewCacheStorage cacheStorage;
        /* access modifiers changed from: private */
        public IChildGravityResolver childGravityResolver;
        /* access modifiers changed from: private */
        public IFinishingCriteria finishingCriteria;
        /* access modifiers changed from: private */
        public IGravityModifiersFactory gravityModifiersFactory;
        /* access modifiers changed from: private */
        public ChipsLayoutManager layoutManager;
        /* access modifiers changed from: private */
        public HashSet<ILayouterListener> layouterListeners = new HashSet<>();
        /* access modifiers changed from: private */
        public Rect offsetRect;
        /* access modifiers changed from: private */
        public IPlacer placer;
        /* access modifiers changed from: private */
        public AbstractPositionIterator positionIterator;
        /* access modifiers changed from: private */
        public IRowStrategy rowStrategy;

        /* access modifiers changed from: protected */
        @NonNull
        public abstract AbstractLayouter createLayouter();

        Builder() {
        }

        @NonNull
        public Builder offsetRect(@NonNull Rect rect) {
            this.offsetRect = rect;
            return this;
        }

        @NonNull
        public final Builder layoutManager(@NonNull ChipsLayoutManager chipsLayoutManager) {
            this.layoutManager = chipsLayoutManager;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder cacheStorage(@NonNull IViewCacheStorage iViewCacheStorage) {
            this.cacheStorage = iViewCacheStorage;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public Builder rowStrategy(IRowStrategy iRowStrategy) {
            this.rowStrategy = iRowStrategy;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder canvas(@NonNull IBorder iBorder) {
            this.border = iBorder;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder gravityModifiersFactory(@NonNull IGravityModifiersFactory iGravityModifiersFactory) {
            this.gravityModifiersFactory = iGravityModifiersFactory;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder childGravityResolver(@NonNull IChildGravityResolver iChildGravityResolver) {
            this.childGravityResolver = iChildGravityResolver;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder finishingCriteria(@NonNull IFinishingCriteria iFinishingCriteria) {
            this.finishingCriteria = iFinishingCriteria;
            return this;
        }

        @NonNull
        public final Builder placer(@NonNull IPlacer iPlacer) {
            this.placer = iPlacer;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder breaker(@NonNull ILayoutRowBreaker iLayoutRowBreaker) {
            AssertionUtils.assertNotNull(iLayoutRowBreaker, "breaker shouldn't be null");
            this.breaker = iLayoutRowBreaker;
            return this;
        }

        /* access modifiers changed from: 0000 */
        @NonNull
        public final Builder addLayouterListeners(@NonNull List<ILayouterListener> list) {
            this.layouterListeners.addAll(list);
            return this;
        }

        @NonNull
        public Builder positionIterator(AbstractPositionIterator abstractPositionIterator) {
            this.positionIterator = abstractPositionIterator;
            return this;
        }

        public final AbstractLayouter build() {
            if (this.layoutManager == null) {
                throw new IllegalStateException("layoutManager can't be null, call #layoutManager()");
            } else if (this.breaker == null) {
                throw new IllegalStateException("breaker can't be null, call #breaker()");
            } else if (this.border == null) {
                throw new IllegalStateException("border can't be null, call #border()");
            } else if (this.cacheStorage == null) {
                throw new IllegalStateException("cacheStorage can't be null, call #cacheStorage()");
            } else if (this.rowStrategy == null) {
                throw new IllegalStateException("rowStrategy can't be null, call #rowStrategy()");
            } else if (this.offsetRect == null) {
                throw new IllegalStateException("offsetRect can't be null, call #offsetRect()");
            } else if (this.finishingCriteria == null) {
                throw new IllegalStateException("finishingCriteria can't be null, call #finishingCriteria()");
            } else if (this.placer == null) {
                throw new IllegalStateException("placer can't be null, call #placer()");
            } else if (this.gravityModifiersFactory == null) {
                throw new IllegalStateException("gravityModifiersFactory can't be null, call #gravityModifiersFactory()");
            } else if (this.childGravityResolver == null) {
                throw new IllegalStateException("childGravityResolver can't be null, call #childGravityResolver()");
            } else if (this.positionIterator != null) {
                return createLayouter();
            } else {
                throw new IllegalStateException("positionIterator can't be null, call #positionIterator()");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract Rect createViewRect(View view);

    public abstract int getEndRowBorder();

    public abstract int getRowLength();

    public abstract int getStartRowBorder();

    /* access modifiers changed from: 0000 */
    public abstract boolean isAttachedViewFromNewRow(View view);

    /* access modifiers changed from: 0000 */
    public abstract boolean isReverseOrder();

    /* access modifiers changed from: 0000 */
    public abstract void onAfterLayout();

    /* access modifiers changed from: 0000 */
    public abstract void onInterceptAttachView(View view);

    /* access modifiers changed from: 0000 */
    public abstract void onPreLayout();

    AbstractLayouter(Builder builder) {
        this.layoutManager = builder.layoutManager;
        this.cacheStorage = builder.cacheStorage;
        this.border = builder.border;
        this.childGravityResolver = builder.childGravityResolver;
        this.finishingCriteria = builder.finishingCriteria;
        this.placer = builder.placer;
        this.viewTop = builder.offsetRect.top;
        this.viewBottom = builder.offsetRect.bottom;
        this.viewRight = builder.offsetRect.right;
        this.viewLeft = builder.offsetRect.left;
        this.layouterListeners = builder.layouterListeners;
        this.breaker = builder.breaker;
        this.gravityModifiersFactory = builder.gravityModifiersFactory;
        this.rowStrategy = builder.rowStrategy;
        this.positionIterator = builder.positionIterator;
    }

    /* access modifiers changed from: 0000 */
    public void setFinishingCriteria(@NonNull IFinishingCriteria iFinishingCriteria) {
        this.finishingCriteria = iFinishingCriteria;
    }

    public AbstractPositionIterator positionIterator() {
        return this.positionIterator;
    }

    public boolean isRowCompleted() {
        return this.isRowCompleted;
    }

    public List<Item> getCurrentRowItems() {
        LinkedList linkedList = new LinkedList();
        LinkedList<Pair> linkedList2 = new LinkedList<>(this.rowViews);
        if (isReverseOrder()) {
            Collections.reverse(linkedList2);
        }
        for (Pair pair : linkedList2) {
            linkedList.add(new Item((Rect) pair.first, this.layoutManager.getPosition((View) pair.second)));
        }
        return linkedList;
    }

    public final int getCurrentViewPosition() {
        return this.currentViewPosition;
    }

    /* access modifiers changed from: 0000 */
    public final IViewCacheStorage getCacheStorage() {
        return this.cacheStorage;
    }

    public void addLayouterListener(ILayouterListener iLayouterListener) {
        if (iLayouterListener != null) {
            this.layouterListeners.add(iLayouterListener);
        }
    }

    public void removeLayouterListener(ILayouterListener iLayouterListener) {
        this.layouterListeners.remove(iLayouterListener);
    }

    private void notifyLayouterListeners() {
        for (ILayouterListener onLayoutRow : this.layouterListeners) {
            onLayoutRow.onLayoutRow(this);
        }
    }

    public final int getPreviousRowSize() {
        return this.previousRowSize;
    }

    private void calculateView(View view) {
        this.currentViewHeight = this.layoutManager.getDecoratedMeasuredHeight(view);
        this.currentViewWidth = this.layoutManager.getDecoratedMeasuredWidth(view);
        this.currentViewPosition = this.layoutManager.getPosition(view);
    }

    @CallSuper
    public final boolean placeView(View view) {
        this.layoutManager.measureChildWithMargins(view, 0, 0);
        calculateView(view);
        if (canNotBePlacedInCurrentRow()) {
            this.isRowCompleted = true;
            layoutRow();
        }
        if (isFinishedLayouting()) {
            return false;
        }
        this.rowSize++;
        this.rowViews.add(new Pair(createViewRect(view), view));
        return true;
    }

    public final boolean isFinishedLayouting() {
        return this.finishingCriteria.isFinishedLayouting(this);
    }

    public final boolean canNotBePlacedInCurrentRow() {
        return this.breaker.isRowBroke(this);
    }

    /* access modifiers changed from: 0000 */
    public void setPlacer(@NonNull IPlacer iPlacer) {
        this.placer = iPlacer;
    }

    @CallSuper
    public final boolean onAttachView(View view) {
        calculateView(view);
        if (isAttachedViewFromNewRow(view)) {
            notifyLayouterListeners();
            this.rowSize = 0;
        }
        onInterceptAttachView(view);
        if (isFinishedLayouting()) {
            return false;
        }
        this.rowSize++;
        this.layoutManager.attachView(view);
        return true;
    }

    public final void layoutRow() {
        onPreLayout();
        if (this.rowViews.size() > 0) {
            this.rowStrategy.applyStrategy(this, getCurrentRowItems());
        }
        for (Pair pair : this.rowViews) {
            View view = (View) pair.second;
            Rect applyChildGravity = applyChildGravity(view, (Rect) pair.first);
            this.placer.addView(view);
            this.layoutManager.layoutDecorated(view, applyChildGravity.left, applyChildGravity.top, applyChildGravity.right, applyChildGravity.bottom);
        }
        onAfterLayout();
        notifyLayouterListeners();
        this.previousRowSize = this.rowSize;
        this.rowSize = 0;
        this.rowViews.clear();
        this.isRowCompleted = false;
    }

    private Rect applyChildGravity(View view, Rect rect) {
        return this.gravityModifiersFactory.getGravityModifier(this.childGravityResolver.getItemGravity(getLayoutManager().getPosition(view))).modifyChildRect(getStartRowBorder(), getEndRowBorder(), rect);
    }

    @NonNull
    public ChipsLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int getViewTop() {
        return this.viewTop;
    }

    public Rect getRowRect() {
        return new Rect(getCanvasLeftBorder(), getViewTop(), getCanvasRightBorder(), getViewBottom());
    }

    public int getViewBottom() {
        return this.viewBottom;
    }

    public final int getViewLeft() {
        return this.viewLeft;
    }

    public final int getViewRight() {
        return this.viewRight;
    }

    public final int getCurrentViewWidth() {
        return this.currentViewWidth;
    }

    public final int getCurrentViewHeight() {
        return this.currentViewHeight;
    }

    public final int getCanvasRightBorder() {
        return this.border.getCanvasRightBorder();
    }

    public final int getCanvasBottomBorder() {
        return this.border.getCanvasBottomBorder();
    }

    public final int getCanvasLeftBorder() {
        return this.border.getCanvasLeftBorder();
    }

    public final int getCanvasTopBorder() {
        return this.border.getCanvasTopBorder();
    }
}
