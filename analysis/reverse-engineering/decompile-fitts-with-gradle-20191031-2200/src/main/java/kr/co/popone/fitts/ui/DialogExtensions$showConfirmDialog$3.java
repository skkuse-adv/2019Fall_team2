package kr.co.popone.fitts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$showConfirmDialog$3 implements OnCancelListener {
    final /* synthetic */ Function0 $cancelListener;

    DialogExtensions$showConfirmDialog$3(Function0 function0) {
        this.$cancelListener = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Function0 function0 = this.$cancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
