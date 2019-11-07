package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import androidx.annotation.IntRange;

public interface IRowBreaker {
    boolean isItemBreakRow(@IntRange(from = 0) int i);
}
