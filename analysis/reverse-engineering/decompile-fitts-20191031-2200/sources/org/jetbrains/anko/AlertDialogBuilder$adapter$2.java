package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.jvm.functions.Function1;

final class AlertDialogBuilder$adapter$2 implements OnClickListener {
    final /* synthetic */ Function1 $callback;

    AlertDialogBuilder$adapter$2(Function1 function1) {
        this.$callback = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.$callback.invoke(Integer.valueOf(i));
    }
}
