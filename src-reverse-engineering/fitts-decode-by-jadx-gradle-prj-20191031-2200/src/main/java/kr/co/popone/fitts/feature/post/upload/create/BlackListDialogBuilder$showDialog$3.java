package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.post.upload.create.BlackListDialogBuilder.Listener;

final class BlackListDialogBuilder$showDialog$3 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Listener $listener;

    BlackListDialogBuilder$showDialog$3(Dialog dialog, Listener listener) {
        this.$dialog = dialog;
        this.$listener = listener;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        this.$listener.onCancel();
    }
}
