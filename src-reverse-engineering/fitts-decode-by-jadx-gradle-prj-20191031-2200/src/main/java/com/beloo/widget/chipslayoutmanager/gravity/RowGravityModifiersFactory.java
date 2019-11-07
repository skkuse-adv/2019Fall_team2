package com.beloo.widget.chipslayoutmanager.gravity;

import android.util.SparseArray;

public class RowGravityModifiersFactory implements IGravityModifiersFactory {
    private SparseArray<IGravityModifier> gravityModifierMap = new SparseArray<>();

    public RowGravityModifiersFactory() {
        CenterInRowGravityModifier centerInRowGravityModifier = new CenterInRowGravityModifier();
        TopGravityModifier topGravityModifier = new TopGravityModifier();
        BottomGravityModifier bottomGravityModifier = new BottomGravityModifier();
        this.gravityModifierMap.put(48, topGravityModifier);
        this.gravityModifierMap.put(80, bottomGravityModifier);
        this.gravityModifierMap.put(17, centerInRowGravityModifier);
        this.gravityModifierMap.put(16, centerInRowGravityModifier);
    }

    public IGravityModifier getGravityModifier(int i) {
        IGravityModifier iGravityModifier = (IGravityModifier) this.gravityModifierMap.get(i);
        return iGravityModifier == null ? (IGravityModifier) this.gravityModifierMap.get(16) : iGravityModifier;
    }
}
