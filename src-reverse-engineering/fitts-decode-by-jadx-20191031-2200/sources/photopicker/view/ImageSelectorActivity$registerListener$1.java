package photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;

final class ImageSelectorActivity$registerListener$1 implements OnClickListener {
    final /* synthetic */ ImageSelectorActivity this$0;

    ImageSelectorActivity$registerListener$1(ImageSelectorActivity imageSelectorActivity) {
        this.this$0 = imageSelectorActivity;
    }

    public final void onClick(View view) {
        FolderWindow access$getFolderWindow$p = this.this$0.folderWindow;
        if (access$getFolderWindow$p == null) {
            Intrinsics.throwNpe();
        }
        if (access$getFolderWindow$p.isShowing()) {
            FolderWindow access$getFolderWindow$p2 = this.this$0.folderWindow;
            if (access$getFolderWindow$p2 == null) {
                Intrinsics.throwNpe();
            }
            access$getFolderWindow$p2.dismiss();
            return;
        }
        FolderWindow access$getFolderWindow$p3 = this.this$0.folderWindow;
        if (access$getFolderWindow$p3 == null) {
            Intrinsics.throwNpe();
        }
        access$getFolderWindow$p3.setOutsideTouchable(false);
        FolderWindow access$getFolderWindow$p4 = this.this$0.folderWindow;
        if (access$getFolderWindow$p4 == null) {
            Intrinsics.throwNpe();
        }
        access$getFolderWindow$p4.showAsDropDown(view);
    }
}
