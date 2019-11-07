package com.paginate.abslistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paginate.R$layout;

public interface LoadingListItemCreator {
    public static final LoadingListItemCreator DEFAULT = new LoadingListItemCreator() {
        public void bindView(int i, View view) {
        }

        public View newView(int i, ViewGroup viewGroup) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.loading_row, viewGroup, false);
        }
    };

    void bindView(int i, View view);

    View newView(int i, ViewGroup viewGroup);
}
