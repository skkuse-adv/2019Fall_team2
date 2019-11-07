package org.jetbrains.anko.appcompat.v7;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

final class SupportAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0 implements OnKeyListener {
    private final /* synthetic */ Function3 function;

    SupportAlertBuilderKt$sam$android_content_DialogInterface_OnKeyListener$0(Function3 function3) {
        this.function = function3;
    }

    public final /* synthetic */ boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Object invoke = this.function.invoke(dialogInterface, Integer.valueOf(i), keyEvent);
        Intrinsics.checkExpressionValueIsNotNull(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
