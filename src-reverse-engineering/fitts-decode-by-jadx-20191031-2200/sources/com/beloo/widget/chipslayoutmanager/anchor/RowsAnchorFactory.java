package com.beloo.widget.chipslayoutmanager.anchor;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.ChildViewsIterable;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;
import java.util.Iterator;

public class RowsAnchorFactory extends AbstractAnchorFactory {
    private ChildViewsIterable childViews;

    public /* bridge */ /* synthetic */ AnchorViewState createNotFound() {
        return super.createNotFound();
    }

    public RowsAnchorFactory(LayoutManager layoutManager, ICanvas iCanvas) {
        super(layoutManager, iCanvas);
        this.childViews = new ChildViewsIterable(layoutManager);
    }

    public AnchorViewState getAnchor() {
        AnchorViewState notFoundState = AnchorViewState.getNotFoundState();
        Iterator it = this.childViews.iterator();
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            View view = (View) it.next();
            AnchorViewState createAnchorState = createAnchorState(view);
            int position = this.lm.getPosition(view);
            int decoratedTop = this.lm.getDecoratedTop(view);
            if (getCanvas().isInside(new Rect(createAnchorState.getAnchorViewRect())) && !createAnchorState.isRemoving()) {
                if (i2 > position) {
                    notFoundState = createAnchorState;
                    i2 = position;
                }
                if (i > decoratedTop) {
                    i = decoratedTop;
                }
            }
        }
        if (!notFoundState.isNotFoundState()) {
            notFoundState.getAnchorViewRect().top = i;
            notFoundState.setPosition(Integer.valueOf(i2));
        }
        return notFoundState;
    }

    public void resetRowCoordinates(AnchorViewState anchorViewState) {
        if (!anchorViewState.isNotFoundState()) {
            Rect anchorViewRect = anchorViewState.getAnchorViewRect();
            anchorViewRect.left = getCanvas().getCanvasLeftBorder();
            anchorViewRect.right = getCanvas().getCanvasRightBorder();
        }
    }
}
