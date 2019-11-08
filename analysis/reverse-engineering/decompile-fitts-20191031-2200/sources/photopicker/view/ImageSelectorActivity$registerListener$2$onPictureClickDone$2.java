package photopicker.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class ImageSelectorActivity$registerListener$2$onPictureClickDone$2 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;

    ImageSelectorActivity$registerListener$2$onPictureClickDone$2(Dialog dialog) {
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
