package photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import org.jetbrains.annotations.NotNull;

final class FolderWindow$initView$1 implements OnClickListener {
    final /* synthetic */ FolderWindow this$0;

    FolderWindow$initView$1(FolderWindow folderWindow) {
        this.this$0 = folderWindow;
    }

    public final void onClick(View view) {
        if (!this.this$0.isDismiss) {
            this.this$0.isDismiss = true;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.this$0.context, C0001R$anim.fade_out);
        RecyclerView access$getRecyclerView$p = this.this$0.recyclerView;
        if (access$getRecyclerView$p == null) {
            Intrinsics.throwNpe();
        }
        access$getRecyclerView$p.startAnimation(loadAnimation);
        this.this$0.dismiss();
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FolderWindow$initView$1 this$0;

            public void onAnimationEnd(@NotNull Animation animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }

            public void onAnimationRepeat(@NotNull Animation animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }

            {
                this.this$0 = r1;
            }

            public void onAnimationStart(@NotNull Animation animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                this.this$0.this$0.isDismiss = false;
                FolderWindow$initView$1.super.dismiss();
            }
        });
    }
}
