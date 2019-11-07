package com.beloo.widget.chipslayoutmanager.util.log;

import android.util.SparseArray;
import android.view.View;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import java.util.Locale;

class FillLogger implements IFillLogger {
    private int recycledItems;
    private int recycledSize;
    private int requestedItems;
    private int startCacheSize;
    private SparseArray<View> viewCache;

    FillLogger(SparseArray<View> sparseArray) {
        this.viewCache = sparseArray;
    }

    public void onStartLayouter(int i) {
        this.requestedItems = 0;
        this.recycledItems = 0;
        this.startCacheSize = this.viewCache.size();
        StringBuilder sb = new StringBuilder();
        sb.append("start position = ");
        sb.append(i);
        String str = "fillWithLayouter";
        Log.d(str, sb.toString(), 3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cached items = ");
        sb2.append(this.startCacheSize);
        Log.d(str, sb2.toString(), 3);
    }

    public void onItemRequested() {
        this.requestedItems++;
    }

    public void onItemRecycled() {
        this.recycledItems++;
    }

    public void onFinishedLayouter() {
        Log.d("fillWithLayouter", String.format(Locale.getDefault(), "reattached items = %d : requested items = %d recycledItems = %d", new Object[]{Integer.valueOf(this.startCacheSize - this.viewCache.size()), Integer.valueOf(this.requestedItems), Integer.valueOf(this.recycledItems)}), 3);
    }

    public void onAfterLayouter() {
        this.recycledSize = this.viewCache.size();
    }

    public void onRemovedAndRecycled(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(" recycle position =");
        sb.append(this.viewCache.keyAt(i));
        Log.d("fillWithLayouter", sb.toString(), 3);
        this.recycledSize++;
    }

    public void onAfterRemovingViews() {
        StringBuilder sb = new StringBuilder();
        sb.append("recycled count = ");
        sb.append(this.recycledSize);
        Log.d("fillWithLayouter", sb.toString(), 3);
    }

    public void onBeforeLayouter(AnchorViewState anchorViewState) {
        if (anchorViewState.getAnchorViewRect() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("anchorPos ");
            sb.append(anchorViewState.getPosition());
            String str = "fill";
            Log.d(str, sb.toString(), 3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("anchorTop ");
            sb2.append(anchorViewState.getAnchorViewRect().top);
            Log.d(str, sb2.toString(), 3);
        }
    }
}
