package org.jetbrains.anko;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CustomServicesKt {
    @NotNull
    public static final Vibrator getVibrator(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("vibrator");
        if (systemService != null) {
            return (Vibrator) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
    }

    @NotNull
    public static final LayoutInflater getLayoutInflater(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            return (LayoutInflater) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
