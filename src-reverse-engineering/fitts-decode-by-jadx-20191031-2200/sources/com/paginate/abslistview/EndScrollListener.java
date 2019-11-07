package com.paginate.abslistview;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class EndScrollListener implements OnScrollListener {
    private final Callback callback;
    private OnScrollListener delegate;
    private int visibleThreshold = 5;

    public interface Callback {
        void onEndReached();
    }

    public EndScrollListener(Callback callback2) {
        this.callback = callback2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i3 - i2 <= this.visibleThreshold + i) {
            this.callback.onEndReached();
        }
        OnScrollListener onScrollListener = this.delegate;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        OnScrollListener onScrollListener = this.delegate;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setThreshold(int i) {
        this.visibleThreshold = Math.max(0, i);
    }

    public void setDelegate(OnScrollListener onScrollListener) {
        this.delegate = onScrollListener;
    }

    public OnScrollListener getDelegateScrollListener() {
        return this.delegate;
    }
}
