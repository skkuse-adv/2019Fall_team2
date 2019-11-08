package com.beloo.widget.chipslayoutmanager.gravity;

import android.util.SparseArray;

public class ColumnGravityModifiersFactory implements IGravityModifiersFactory {
    private SparseArray<IGravityModifier> gravityModifierMap = new SparseArray<>();

    public ColumnGravityModifiersFactory() {
        CenterInColumnGravityModifier centerInColumnGravityModifier = new CenterInColumnGravityModifier();
        this.gravityModifierMap.put(17, centerInColumnGravityModifier);
        this.gravityModifierMap.put(1, centerInColumnGravityModifier);
        this.gravityModifierMap.put(3, new LeftGravityModifier());
        this.gravityModifierMap.put(5, new RightGravityModifier());
    }

    public IGravityModifier getGravityModifier(int i) {
        IGravityModifier iGravityModifier = (IGravityModifier) this.gravityModifierMap.get(i);
        return iGravityModifier == null ? (IGravityModifier) this.gravityModifierMap.get(1) : iGravityModifier;
    }
}
