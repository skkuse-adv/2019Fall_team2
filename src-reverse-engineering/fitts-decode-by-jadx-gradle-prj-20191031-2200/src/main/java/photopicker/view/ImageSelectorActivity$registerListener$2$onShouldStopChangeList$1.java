package photopicker.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import photopicker.adapter.ImageListAdapter;
import photopicker.adapter.ImageListAdapter.ViewHolder;
import photopicker.model.LocalMedia;

final class ImageSelectorActivity$registerListener$2$onShouldStopChangeList$1 implements OnClickListener {
    final /* synthetic */ ViewHolder $contentHolder;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ LocalMedia $image;
    final /* synthetic */ ImageSelectorActivity$registerListener$2 this$0;

    ImageSelectorActivity$registerListener$2$onShouldStopChangeList$1(ImageSelectorActivity$registerListener$2 imageSelectorActivity$registerListener$2, ViewHolder viewHolder, LocalMedia localMedia, Dialog dialog) {
        this.this$0 = imageSelectorActivity$registerListener$2;
        this.$contentHolder = viewHolder;
        this.$image = localMedia;
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        ImageListAdapter access$getImageAdapter$p = this.this$0.this$0.imageAdapter;
        if (access$getImageAdapter$p == null) {
            Intrinsics.throwNpe();
        }
        access$getImageAdapter$p.changeCheckboxState(this.$contentHolder, this.$image);
        this.$dialog.dismiss();
    }
}
