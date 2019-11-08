package kr.co.popone.fitts.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$showConfirmDialog$2 implements OnClickListener {
    final /* synthetic */ Function0 $cancelListener;
    final /* synthetic */ Dialog $dialog;

    DialogExtensions$showConfirmDialog$2(Dialog dialog, Function0 function0) {
        this.$dialog = dialog;
        this.$cancelListener = function0;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        Function0 function0 = this.$cancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
