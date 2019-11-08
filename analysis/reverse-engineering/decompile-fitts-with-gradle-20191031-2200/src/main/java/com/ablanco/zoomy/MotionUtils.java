package com.ablanco.zoomy;

import android.graphics.PointF;
import android.view.MotionEvent;

class MotionUtils {
    static void midPointOfEvent(PointF pointF, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
        }
    }
}
