package com.beloo.widget.chipslayoutmanager.util;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class LayoutManagerUtil {
    public static void requestLayoutWithAnimations(final LayoutManager layoutManager) {
        layoutManager.postOnAnimation(new Runnable() {
            public void run() {
                layoutManager.requestLayout();
                layoutManager.requestSimpleAnimationsInNextLayout();
            }
        });
    }
}
