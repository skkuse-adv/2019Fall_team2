package org.jetbrains.anko;

import android.app.AlertDialog;
import android.content.Context;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class AndroidAlertBuilderKt {
    @NotNull
    private static final Function1<Context, AlertBuilder<AlertDialog>> Android = AndroidAlertBuilderKt$Android$1.INSTANCE;

    @NotNull
    public static final Function1<Context, AlertBuilder<AlertDialog>> getAndroid() {
        return Android;
    }
}
