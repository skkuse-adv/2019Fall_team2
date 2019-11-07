package photopicker.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import photopicker.model.LocalMedia;

final class ImageSelectorActivity$registerListener$2$onPictureClickDone$1 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ LocalMedia $media;
    final /* synthetic */ ImageSelectorActivity$registerListener$2 this$0;

    ImageSelectorActivity$registerListener$2$onPictureClickDone$1(ImageSelectorActivity$registerListener$2 imageSelectorActivity$registerListener$2, LocalMedia localMedia, Dialog dialog) {
        this.this$0 = imageSelectorActivity$registerListener$2;
        this.$media = localMedia;
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.this$0.this$0.startCrop(this.$media.getPath());
        this.$dialog.dismiss();
    }
}
