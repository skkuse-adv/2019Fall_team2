package com.beloo.widget.chipslayoutmanager.util;

import com.beloo.widget.chipslayoutmanager.layouter.IStateFactory;

public class StateHelper {
    public static boolean isInfinite(IStateFactory iStateFactory) {
        return iStateFactory.getSizeMode() == 0 && iStateFactory.getEnd() == 0;
    }
}
