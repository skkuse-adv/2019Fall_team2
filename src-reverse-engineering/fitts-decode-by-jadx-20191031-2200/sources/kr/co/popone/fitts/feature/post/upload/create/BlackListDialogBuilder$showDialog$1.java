package kr.co.popone.fitts.feature.post.upload.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kr.co.popone.fitts.feature.post.upload.create.BlackListDialogBuilder.Listener;

final class BlackListDialogBuilder$showDialog$1 implements OnCancelListener {
    final /* synthetic */ Listener $listener;

    BlackListDialogBuilder$showDialog$1(Listener listener) {
        this.$listener = listener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.$listener.onCancel();
    }
}
