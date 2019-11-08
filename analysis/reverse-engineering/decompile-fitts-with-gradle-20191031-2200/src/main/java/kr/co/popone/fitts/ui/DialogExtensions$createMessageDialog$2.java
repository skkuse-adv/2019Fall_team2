package kr.co.popone.fitts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$createMessageDialog$2 implements OnCancelListener {
    final /* synthetic */ Function0 $dismissListener;

    DialogExtensions$createMessageDialog$2(Function0 function0) {
        this.$dismissListener = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Function0 function0 = this.$dismissListener;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
