package org.jetbrains.anko.appcompat.v7;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class SupportAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0 implements OnCancelListener {
    private final /* synthetic */ Function1 function;

    SupportAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(dialogInterface), "invoke(...)");
    }
}
