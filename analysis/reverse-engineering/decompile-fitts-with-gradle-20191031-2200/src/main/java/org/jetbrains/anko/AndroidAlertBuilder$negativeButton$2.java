package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class AndroidAlertBuilder$negativeButton$2 implements OnClickListener {
    final /* synthetic */ Function1 $onClicked;

    AndroidAlertBuilder$negativeButton$2(Function1 function1) {
        this.$onClicked = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function1 function1 = this.$onClicked;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function1.invoke(dialogInterface);
    }
}
