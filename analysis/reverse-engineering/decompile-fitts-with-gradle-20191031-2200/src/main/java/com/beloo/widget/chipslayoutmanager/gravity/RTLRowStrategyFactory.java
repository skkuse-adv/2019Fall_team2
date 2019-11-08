package com.beloo.widget.chipslayoutmanager.gravity;

public class RTLRowStrategyFactory implements IRowStrategyFactory {
    public IRowStrategy createRowStrategy(int i) {
        if (i == 2) {
            return new RTLRowFillStrategy();
        }
        if (i == 4) {
            return new RTLRowFillSpaceStrategy();
        }
        if (i == 5) {
            return new RTLRowFillSpaceCenterStrategy();
        }
        if (i != 6) {
            return new EmptyRowStrategy();
        }
        return new RTLRowFillSpaceCenterDenseStrategy();
    }
}
