package kr.co.popone.fitts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.functions.Function0;

final class DialogExtensions$showUpdateDialog$1 implements OnClickListener {
    final /* synthetic */ Function0 $confirmListener;

    DialogExtensions$showUpdateDialog$1(Function0 function0) {
        this.$confirmListener = function0;
    }

    public final void onClick(View view) {
        this.$confirmListener.invoke();
    }
}
