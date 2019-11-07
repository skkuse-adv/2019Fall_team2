package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

class LeftGravityModifier implements IGravityModifier {
    LeftGravityModifier() {
    }

    public Rect modifyChildRect(int i, int i2, Rect rect) {
        Rect rect2 = new Rect(rect);
        int i3 = rect2.left;
        if (i3 > i) {
            rect2.right -= i3 - i;
            rect2.left = i;
        }
        return rect2;
    }
}
