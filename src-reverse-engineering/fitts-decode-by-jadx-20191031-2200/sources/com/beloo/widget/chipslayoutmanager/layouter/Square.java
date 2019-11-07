package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.ChildViewsIterable;
import java.util.Iterator;

abstract class Square implements ICanvas {
    private View bottomView;
    private ChildViewsIterable childViews;
    private boolean isFirstItemAdded;
    private View leftView;
    LayoutManager lm;
    private Integer maxPositionOnScreen;
    private Integer minPositionOnScreen;
    private View rightView;
    private View topView;

    Square(LayoutManager layoutManager) {
        this.lm = layoutManager;
        this.childViews = new ChildViewsIterable(layoutManager);
    }

    public Rect getCanvasRect() {
        return new Rect(getCanvasLeftBorder(), getCanvasTopBorder(), getCanvasRightBorder(), getCanvasBottomBorder());
    }

    public Rect getViewRect(View view) {
        return new Rect(this.lm.getDecoratedLeft(view), this.lm.getDecoratedTop(view), this.lm.getDecoratedRight(view), this.lm.getDecoratedBottom(view));
    }

    public boolean isInside(Rect rect) {
        return getCanvasRect().intersect(new Rect(rect));
    }

    public boolean isInside(View view) {
        return isInside(getViewRect(view));
    }

    public boolean isFullyVisible(View view) {
        return isFullyVisible(getViewRect(view));
    }

    public boolean isFullyVisible(Rect rect) {
        return rect.top >= getCanvasTopBorder() && rect.bottom <= getCanvasBottomBorder() && rect.left >= getCanvasLeftBorder() && rect.right <= getCanvasRightBorder();
    }

    public void findBorderViews() {
        this.topView = null;
        this.bottomView = null;
        this.leftView = null;
        this.rightView = null;
        Integer valueOf = Integer.valueOf(-1);
        this.minPositionOnScreen = valueOf;
        this.maxPositionOnScreen = valueOf;
        this.isFirstItemAdded = false;
        if (this.lm.getChildCount() > 0) {
            View childAt = this.lm.getChildAt(0);
            this.topView = childAt;
            this.bottomView = childAt;
            this.leftView = childAt;
            this.rightView = childAt;
            Iterator it = this.childViews.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                int position = this.lm.getPosition(view);
                if (isInside(view)) {
                    if (this.lm.getDecoratedTop(view) < this.lm.getDecoratedTop(this.topView)) {
                        this.topView = view;
                    }
                    if (this.lm.getDecoratedBottom(view) > this.lm.getDecoratedBottom(this.bottomView)) {
                        this.bottomView = view;
                    }
                    if (this.lm.getDecoratedLeft(view) < this.lm.getDecoratedLeft(this.leftView)) {
                        this.leftView = view;
                    }
                    if (this.lm.getDecoratedRight(view) > this.lm.getDecoratedRight(this.rightView)) {
                        this.rightView = view;
                    }
                    if (this.minPositionOnScreen.intValue() == -1 || position < this.minPositionOnScreen.intValue()) {
                        this.minPositionOnScreen = Integer.valueOf(position);
                    }
                    if (this.maxPositionOnScreen.intValue() == -1 || position > this.maxPositionOnScreen.intValue()) {
                        this.maxPositionOnScreen = Integer.valueOf(position);
                    }
                    if (position == 0) {
                        this.isFirstItemAdded = true;
                    }
                }
            }
        }
    }

    public View getTopView() {
        return this.topView;
    }

    public View getBottomView() {
        return this.bottomView;
    }

    public View getLeftView() {
        return this.leftView;
    }

    public View getRightView() {
        return this.rightView;
    }

    public Integer getMinPositionOnScreen() {
        return this.minPositionOnScreen;
    }

    public Integer getMaxPositionOnScreen() {
        return this.maxPositionOnScreen;
    }

    public boolean isFirstItemAdded() {
        return this.isFirstItemAdded;
    }
}
