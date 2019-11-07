package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;

class CenterInRowGravityModifier implements IGravityModifier {
    CenterInRowGravityModifier() {
    }

    public Rect modifyChildRect(int i, int i2, Rect rect) {
        if (rect.top < i) {
            throw new IllegalArgumentException("top point of input rect can't be lower than minTop");
        } else if (rect.bottom <= i2) {
            Rect rect2 = new Rect(rect);
            int i3 = ((i2 - i) - (rect2.bottom - rect2.top)) / 2;
            rect2.top = i + i3;
            rect2.bottom = i2 - i3;
            return rect2;
        } else {
            throw new IllegalArgumentException("bottom point of input rect can't be bigger than maxTop");
        }
    }
}
