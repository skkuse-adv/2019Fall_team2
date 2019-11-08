package photopicker.view;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import photopicker.adapter.ImageListAdapter;
import photopicker.model.LocalMediaFolder;
import photopicker.utils.LocalMediaLoader.LocalMediaLoadListener;

public final class ImageSelectorActivity$permissionListener$1$onPermissionGranted$1 implements LocalMediaLoadListener {
    final /* synthetic */ ImageSelectorActivity$permissionListener$1 this$0;

    ImageSelectorActivity$permissionListener$1$onPermissionGranted$1(ImageSelectorActivity$permissionListener$1 imageSelectorActivity$permissionListener$1) {
        this.this$0 = imageSelectorActivity$permissionListener$1;
    }

    public void loadComplete(@NotNull List<LocalMediaFolder> list) {
        Intrinsics.checkParameterIsNotNull(list, "folders");
        FolderWindow access$getFolderWindow$p = this.this$0.this$0.folderWindow;
        if (access$getFolderWindow$p != null) {
            access$getFolderWindow$p.bindFolder(list);
        }
        ImageListAdapter access$getImageAdapter$p = this.this$0.this$0.imageAdapter;
        if (access$getImageAdapter$p != null) {
            access$getImageAdapter$p.bindImages(((LocalMediaFolder) list.get(0)).getImages());
        }
    }
}
