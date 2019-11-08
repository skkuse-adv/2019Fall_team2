package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

final class AndroidAlertBuilder$items$2 implements OnClickListener {
    final /* synthetic */ Function2 $onItemSelected;

    AndroidAlertBuilder$items$2(Function2 function2) {
        this.$onItemSelected = function2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function2 function2 = this.$onItemSelected;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function2.invoke(dialogInterface, Integer.valueOf(i));
    }
}
