package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class CreatePostActivity$showFinishDialog$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ Dialog $this_apply;
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$showFinishDialog$$inlined$apply$lambda$1(Dialog dialog, CreatePostActivity createPostActivity) {
        this.$this_apply = dialog;
        this.this$0 = createPostActivity;
    }

    public final void onClick(View view) {
        this.$this_apply.dismiss();
        this.this$0.getViewModel().savePostTemporary(true);
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
