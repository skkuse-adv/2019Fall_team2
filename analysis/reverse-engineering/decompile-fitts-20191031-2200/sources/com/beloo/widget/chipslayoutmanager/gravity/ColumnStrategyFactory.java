package com.beloo.widget.chipslayoutmanager.gravity;

public class ColumnStrategyFactory implements IRowStrategyFactory {
    public IRowStrategy createRowStrategy(int i) {
        if (i == 2) {
            return new ColumnFillStrategy();
        }
        if (i == 4) {
            return new ColumnFillSpaceStrategy();
        }
        if (i != 5) {
            return i != 6 ? new EmptyRowStrategy() : new ColumnFillSpaceCenterDenseStrategy();
        }
        return new ColumnFillSpaceCenterStrategy();
    }
}
