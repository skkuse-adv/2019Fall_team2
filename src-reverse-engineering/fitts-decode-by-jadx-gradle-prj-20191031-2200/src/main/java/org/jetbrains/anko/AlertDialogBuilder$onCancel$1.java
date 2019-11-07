package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.jvm.functions.Function0;

final class AlertDialogBuilder$onCancel$1 implements OnCancelListener {
    final /* synthetic */ Function0 $callback;

    AlertDialogBuilder$onCancel$1(Function0 function0) {
        this.$callback = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.$callback.invoke();
    }
}
