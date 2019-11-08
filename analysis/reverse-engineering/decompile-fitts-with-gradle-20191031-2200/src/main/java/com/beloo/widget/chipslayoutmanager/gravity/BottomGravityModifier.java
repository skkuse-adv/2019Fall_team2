package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

class BottomGravityModifier implements IGravityModifier {
    BottomGravityModifier() {
    }

    public Rect modifyChildRect(int i, int i2, Rect rect) {
        if (rect.top < i) {
            throw new IllegalArgumentException("top point of input rect can't be lower than minTop");
        } else if (rect.bottom <= i2) {
            Rect rect2 = new Rect(rect);
            int i3 = rect2.bottom;
            if (i3 < i2) {
                rect2.top += i2 - i3;
                rect2.bottom = i2;
            }
            return rect2;
        } else {
            throw new IllegalArgumentException("bottom point of input rect can't be bigger than maxTop");
        }
    }
}
