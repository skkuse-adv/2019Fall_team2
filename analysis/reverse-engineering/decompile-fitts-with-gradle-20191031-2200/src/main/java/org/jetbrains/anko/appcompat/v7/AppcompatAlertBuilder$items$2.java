package org.jetbrains.anko.appcompat.v7;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

final class AppcompatAlertBuilder$items$2 implements OnClickListener {
    final /* synthetic */ Function2 $onItemSelected;

    AppcompatAlertBuilder$items$2(Function2 function2) {
        this.$onItemSelected = function2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function2 function2 = this.$onItemSelected;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function2.invoke(dialogInterface, Integer.valueOf(i));
    }
}
