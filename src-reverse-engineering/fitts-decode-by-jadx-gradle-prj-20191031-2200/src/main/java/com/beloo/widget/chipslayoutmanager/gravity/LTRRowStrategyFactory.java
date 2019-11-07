package com.beloo.widget.chipslayoutmanager.gravity;

public class LTRRowStrategyFactory implements IRowStrategyFactory {
    public IRowStrategy createRowStrategy(int i) {
        if (i == 2) {
            return new LTRRowFillStrategy();
        }
        if (i == 4) {
            return new LTRRowFillSpaceStrategy();
        }
        if (i != 5) {
            return i != 6 ? new EmptyRowStrategy() : new LTRRowFillSpaceCenterDenseStrategy();
        }
        return new LTRRowFillSpaceCenterStrategy();
    }
}
