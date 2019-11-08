package photopicker.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import photopicker.adapter.ImageListAdapter.ViewHolder;
import photopicker.model.LocalMedia;

final class ImageListAdapter$onBindViewHolder$2 implements OnClickListener {
    final /* synthetic */ ViewHolder $contentHolder;
    final /* synthetic */ LocalMedia $image;
    final /* synthetic */ ImageListAdapter this$0;

    ImageListAdapter$onBindViewHolder$2(ImageListAdapter imageListAdapter, ViewHolder viewHolder, LocalMedia localMedia) {
        this.this$0 = imageListAdapter;
        this.$contentHolder = viewHolder;
        this.$image = localMedia;
    }

    public final void onClick(View view) {
        this.this$0.changeCheckboxState(this.$contentHolder, this.$image);
    }
}
