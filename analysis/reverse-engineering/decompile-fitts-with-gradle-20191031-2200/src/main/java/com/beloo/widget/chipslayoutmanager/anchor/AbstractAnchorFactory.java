package com.beloo.widget.chipslayoutmanager.anchor;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;

abstract class AbstractAnchorFactory implements IAnchorFactory {
    private ICanvas canvas;
    LayoutManager lm;

    AbstractAnchorFactory(LayoutManager layoutManager, ICanvas iCanvas) {
        this.lm = layoutManager;
        this.canvas = iCanvas;
    }

    /* access modifiers changed from: 0000 */
    public ICanvas getCanvas() {
        return this.canvas;
    }

    /* access modifiers changed from: 0000 */
    public AnchorViewState createAnchorState(View view) {
        return new AnchorViewState(this.lm.getPosition(view), this.canvas.getViewRect(view));
    }

    public AnchorViewState createNotFound() {
        return AnchorViewState.getNotFoundState();
    }
}
