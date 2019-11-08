package photopicker.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FolderWindow$dismiss$1 implements AnimationListener {
    final /* synthetic */ FolderWindow this$0;

    public void onAnimationEnd(@NotNull Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
    }

    public void onAnimationRepeat(@NotNull Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
    }

    FolderWindow$dismiss$1(FolderWindow folderWindow) {
        this.this$0 = folderWindow;
    }

    public void onAnimationStart(@NotNull Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        this.this$0.isDismiss = false;
        FolderWindow$dismiss$1.super.dismiss();
    }
}
