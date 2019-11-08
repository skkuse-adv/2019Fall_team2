package kr.co.popone.fitts.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$showMessageDialog$1 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Function0 $dismissListener;

    DialogExtensions$showMessageDialog$1(Dialog dialog, Function0 function0) {
        this.$dialog = dialog;
        this.$dismissListener = function0;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        Function0 function0 = this.$dismissListener;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
