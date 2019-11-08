package com.beloo.widget.chipslayoutmanager.gravity;

public class CustomGravityResolver implements IChildGravityResolver {
    private int gravity;

    public CustomGravityResolver(int i) {
        this.gravity = i;
    }

    public int getItemGravity(int i) {
        return this.gravity;
    }
}
