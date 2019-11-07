package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.post.upload.create.PostFirstWriteGuideDialogBuilder.Listener;

final class PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$2 implements OnClickListener {
    final /* synthetic */ Listener $listener$inlined;
    final /* synthetic */ Dialog $this_apply$inlined;

    PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$2(Dialog dialog, Listener listener, String str) {
        this.$this_apply$inlined = dialog;
        this.$listener$inlined = listener;
    }

    public final void onClick(View view) {
        this.$listener$inlined.onConfirm();
        this.$this_apply$inlined.dismiss();
    }
}
