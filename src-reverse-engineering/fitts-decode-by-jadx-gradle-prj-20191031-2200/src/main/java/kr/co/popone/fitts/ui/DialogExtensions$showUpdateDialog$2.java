package kr.co.popone.fitts.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class DialogExtensions$showUpdateDialog$2 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;

    DialogExtensions$showUpdateDialog$2(Dialog dialog) {
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
