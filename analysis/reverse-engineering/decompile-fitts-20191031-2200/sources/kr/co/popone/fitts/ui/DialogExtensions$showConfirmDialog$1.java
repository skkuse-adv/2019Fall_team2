package kr.co.popone.fitts.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$showConfirmDialog$1 implements OnClickListener {
    final /* synthetic */ Function0 $confirmListener;
    final /* synthetic */ Dialog $dialog;

    DialogExtensions$showConfirmDialog$1(Dialog dialog, Function0 function0) {
        this.$dialog = dialog;
        this.$confirmListener = function0;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        Function0 function0 = this.$confirmListener;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
