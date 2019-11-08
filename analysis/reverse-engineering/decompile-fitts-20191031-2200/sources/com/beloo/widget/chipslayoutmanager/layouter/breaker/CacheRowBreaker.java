package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.cache.IViewCacheStorage;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CacheRowBreaker extends RowBreakerDecorator {
    private IViewCacheStorage cacheStorage;

    CacheRowBreaker(IViewCacheStorage iViewCacheStorage, ILayoutRowBreaker iLayoutRowBreaker) {
        super(iLayoutRowBreaker);
        this.cacheStorage = iViewCacheStorage;
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return super.isRowBroke(abstractLayouter) || this.cacheStorage.isPositionEndsRow(abstractLayouter.getCurrentViewPosition());
    }
}
