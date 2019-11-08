package com.ablanco.zoomy;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

class ViewUtils {
    static Bitmap getBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    static Point getViewAbsoluteCords(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point(iArr[0], iArr[1]);
    }
}
