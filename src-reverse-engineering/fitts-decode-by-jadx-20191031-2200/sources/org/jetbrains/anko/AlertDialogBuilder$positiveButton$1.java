package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class AlertDialogBuilder$positiveButton$1 implements OnClickListener {
    final /* synthetic */ Function1 $callback;

    AlertDialogBuilder$positiveButton$1(Function1 function1) {
        this.$callback = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function1 function1 = this.$callback;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function1.invoke(dialogInterface);
    }
}
