package photopicker.view;

import com.gun0912.tedpermission.PermissionListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ImageCropActivity$permissionListener$1 implements PermissionListener {
    final /* synthetic */ ImageCropActivity this$0;

    ImageCropActivity$permissionListener$1(ImageCropActivity imageCropActivity) {
        this.this$0 = imageCropActivity;
    }

    public void onPermissionGranted() {
        this.this$0.initView();
        this.this$0.registerListener();
    }

    public void onPermissionDenied(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "deniedPermissions");
        this.this$0.finish();
    }
}
