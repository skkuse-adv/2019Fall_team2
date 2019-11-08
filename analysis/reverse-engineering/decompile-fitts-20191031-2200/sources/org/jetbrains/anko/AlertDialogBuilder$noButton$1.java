package org.jetbrains.anko;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AlertDialogBuilder$noButton$1 extends Lambda implements Function1<DialogInterface, Unit> {
    public static final AlertDialogBuilder$noButton$1 INSTANCE = new AlertDialogBuilder$noButton$1();

    AlertDialogBuilder$noButton$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DialogInterface) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkParameterIsNotNull(dialogInterface, "receiver$0");
        dialogInterface.dismiss();
    }
}
