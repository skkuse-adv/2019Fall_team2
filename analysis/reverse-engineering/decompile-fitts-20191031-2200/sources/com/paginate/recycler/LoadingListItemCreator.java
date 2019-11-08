package com.paginate.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.paginate.R$layout;

public interface LoadingListItemCreator {
    public static final LoadingListItemCreator DEFAULT = new LoadingListItemCreator() {
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.loading_row, viewGroup, false)) {
            };
        }
    };

    void onBindViewHolder(ViewHolder viewHolder, int i);

    ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);
}
