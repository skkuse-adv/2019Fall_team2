package org.jetbrains.anko.appcompat.v7;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import kotlin.jvm.functions.Function1;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.annotations.NotNull;

public final class SupportAlertBuilderKt {
    @NotNull
    private static final Function1<Context, AlertBuilder<AlertDialog>> Appcompat = SupportAlertBuilderKt$Appcompat$1.INSTANCE;

    @NotNull
    public static final Function1<Context, AlertBuilder<AlertDialog>> getAppcompat() {
        return Appcompat;
    }
}
