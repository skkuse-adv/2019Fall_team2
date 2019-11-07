package photopicker.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import photopicker.adapter.ImageListAdapter.OnImageSelectChangedListener;
import photopicker.model.LocalMedia;
import photopicker.view.ImageSelectorActivity;

final class ImageListAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ LocalMedia $image;
    final /* synthetic */ int $position;
    final /* synthetic */ ImageListAdapter this$0;

    ImageListAdapter$onBindViewHolder$1(ImageListAdapter imageListAdapter, LocalMedia localMedia, int i) {
        this.this$0 = imageListAdapter;
        this.$image = localMedia;
        this.$position = i;
    }

    public final void onClick(View view) {
        if ((this.this$0.selectMode == ImageSelectorActivity.Companion.getMODE_SINGLE() || this.this$0.selectMode == ImageSelectorActivity.Companion.getMODE_SHOWROOM()) && this.this$0.imageSelectChangedListener != null) {
            OnImageSelectChangedListener access$getImageSelectChangedListener$p = this.this$0.imageSelectChangedListener;
            if (access$getImageSelectChangedListener$p == null) {
                Intrinsics.throwNpe();
            }
            access$getImageSelectChangedListener$p.onPictureClickDone(this.$image, this.$position);
            return;
        }
        OnImageSelectChangedListener access$getImageSelectChangedListener$p2 = this.this$0.imageSelectChangedListener;
        if (access$getImageSelectChangedListener$p2 == null) {
            Intrinsics.throwNpe();
        }
        access$getImageSelectChangedListener$p2.onPictureClick(this.$image, this.$position);
    }
}
