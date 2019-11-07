package photopicker.view;

import com.gun0912.tedpermission.PermissionListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import photopicker.utils.LocalMediaLoader;

public final class ImageSelectorActivity$permissionListener$1 implements PermissionListener {
    final /* synthetic */ ImageSelectorActivity this$0;

    ImageSelectorActivity$permissionListener$1(ImageSelectorActivity imageSelectorActivity) {
        this.this$0 = imageSelectorActivity;
    }

    public void onPermissionGranted() {
        this.this$0.initView();
        this.this$0.registerListener();
        new LocalMediaLoader(this.this$0).loadAllImage(new ImageSelectorActivity$permissionListener$1$onPermissionGranted$1(this));
    }

    public void onPermissionDenied(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "deniedPermissions");
        this.this$0.finish();
    }
}
