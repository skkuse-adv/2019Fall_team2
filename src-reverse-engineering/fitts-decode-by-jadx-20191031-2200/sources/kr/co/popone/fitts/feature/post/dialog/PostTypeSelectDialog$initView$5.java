package kr.co.popone.fitts.feature.post.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class PostTypeSelectDialog$initView$5 implements OnDismissListener {
    final /* synthetic */ PostTypeSelectDialog this$0;

    PostTypeSelectDialog$initView$5(PostTypeSelectDialog postTypeSelectDialog) {
        this.this$0 = postTypeSelectDialog;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.this$0.delegate.onDialogDissmiss();
    }
}
