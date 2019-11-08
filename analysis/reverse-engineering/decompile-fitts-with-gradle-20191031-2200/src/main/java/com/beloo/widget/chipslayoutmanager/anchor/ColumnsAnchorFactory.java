package com.beloo.widget.chipslayoutmanager.anchor;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.ChildViewsIterable;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;
import java.util.Iterator;

public class ColumnsAnchorFactory extends AbstractAnchorFactory {
    private ChildViewsIterable childViews;

    public /* bridge */ /* synthetic */ AnchorViewState createNotFound() {
        return super.createNotFound();
    }

    public ColumnsAnchorFactory(LayoutManager layoutManager, ICanvas iCanvas) {
        super(layoutManager, iCanvas);
        this.childViews = new ChildViewsIterable(layoutManager);
    }

    public AnchorViewState getAnchor() {
        AnchorViewState notFoundState = AnchorViewState.getNotFoundState();
        Iterator it = this.childViews.iterator();
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            View view = (View) it.next();
            AnchorViewState createAnchorState = createAnchorState(view);
            int position = this.lm.getPosition(view);
            int decoratedLeft = this.lm.getDecoratedLeft(view);
            int decoratedRight = this.lm.getDecoratedRight(view);
            if (getCanvas().isInside(new Rect(createAnchorState.getAnchorViewRect())) && !createAnchorState.isRemoving()) {
                if (i3 > position) {
                    notFoundState = createAnchorState;
                    i3 = position;
                }
                if (i > decoratedLeft) {
                    i2 = decoratedRight;
                    i = decoratedLeft;
                } else if (i == decoratedLeft) {
                    i2 = Math.max(i2, decoratedRight);
                }
            }
        }
        if (!notFoundState.isNotFoundState()) {
            notFoundState.getAnchorViewRect().left = i;
            notFoundState.getAnchorViewRect().right = i2;
            notFoundState.setPosition(Integer.valueOf(i3));
        }
        return notFoundState;
    }

    public void resetRowCoordinates(AnchorViewState anchorViewState) {
        if (!anchorViewState.isNotFoundState()) {
            Rect anchorViewRect = anchorViewState.getAnchorViewRect();
            anchorViewRect.top = getCanvas().getCanvasTopBorder();
            anchorViewRect.bottom = getCanvas().getCanvasBottomBorder();
        }
    }
}
