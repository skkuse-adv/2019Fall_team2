package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

class RightGravityModifier implements IGravityModifier {
    RightGravityModifier() {
    }

    public Rect modifyChildRect(int i, int i2, Rect rect) {
        Rect rect2 = new Rect(rect);
        int i3 = rect2.right;
        if (i3 < i2) {
            rect2.left += i2 - i3;
            rect2.right = i2;
        }
        return rect2;
    }
}
