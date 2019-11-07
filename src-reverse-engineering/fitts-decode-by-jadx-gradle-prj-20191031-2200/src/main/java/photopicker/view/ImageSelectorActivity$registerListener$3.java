package photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import photopicker.adapter.ImageListAdapter;
import photopicker.model.LocalMedia;

final class ImageSelectorActivity$registerListener$3 implements OnClickListener {
    final /* synthetic */ ImageSelectorActivity this$0;

    ImageSelectorActivity$registerListener$3(ImageSelectorActivity imageSelectorActivity) {
        this.this$0 = imageSelectorActivity;
    }

    public final void onClick(View view) {
        ImageSelectorActivity imageSelectorActivity = this.this$0;
        ImageListAdapter access$getImageAdapter$p = imageSelectorActivity.imageAdapter;
        if (access$getImageAdapter$p == null) {
            Intrinsics.throwNpe();
        }
        imageSelectorActivity.onSelectDone((List<LocalMedia>) access$getImageAdapter$p.getSelectedImages());
    }
}
