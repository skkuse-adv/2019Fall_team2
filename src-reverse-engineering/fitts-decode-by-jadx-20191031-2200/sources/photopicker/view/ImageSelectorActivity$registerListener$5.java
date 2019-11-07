package photopicker.view;

import android.widget.TextView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import photopicker.adapter.ImageFolderAdapter.OnItemClickListener;
import photopicker.adapter.ImageListAdapter;
import photopicker.model.LocalMedia;

public final class ImageSelectorActivity$registerListener$5 implements OnItemClickListener {
    final /* synthetic */ ImageSelectorActivity this$0;

    ImageSelectorActivity$registerListener$5(ImageSelectorActivity imageSelectorActivity) {
        this.this$0 = imageSelectorActivity;
    }

    public void onItemClick(@NotNull String str, @NotNull List<LocalMedia> list) {
        Intrinsics.checkParameterIsNotNull(str, "folderName");
        Intrinsics.checkParameterIsNotNull(list, "images");
        FolderWindow access$getFolderWindow$p = this.this$0.folderWindow;
        if (access$getFolderWindow$p == null) {
            Intrinsics.throwNpe();
        }
        access$getFolderWindow$p.dismiss();
        ImageListAdapter access$getImageAdapter$p = this.this$0.imageAdapter;
        if (access$getImageAdapter$p == null) {
            Intrinsics.throwNpe();
        }
        access$getImageAdapter$p.bindImages(list);
        TextView access$getCurrentFolderName$p = this.this$0.currentFolderName;
        if (access$getCurrentFolderName$p == null) {
            Intrinsics.throwNpe();
        }
        access$getCurrentFolderName$p.setText(str);
    }
}
