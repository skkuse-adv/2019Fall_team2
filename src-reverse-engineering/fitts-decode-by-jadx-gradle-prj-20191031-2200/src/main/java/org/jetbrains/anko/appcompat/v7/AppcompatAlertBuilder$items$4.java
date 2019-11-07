package org.jetbrains.anko.appcompat.v7;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

final class AppcompatAlertBuilder$items$4 implements OnClickListener {
    final /* synthetic */ List $items;
    final /* synthetic */ Function3 $onItemSelected;

    AppcompatAlertBuilder$items$4(Function3 function3, List list) {
        this.$onItemSelected = function3;
        this.$items = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Function3 function3 = this.$onItemSelected;
        Intrinsics.checkExpressionValueIsNotNull(dialogInterface, "dialog");
        function3.invoke(dialogInterface, this.$items.get(i), Integer.valueOf(i));
    }
}
