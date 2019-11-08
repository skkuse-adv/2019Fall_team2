package org.jetbrains.anko;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

public final class UiKt {
    @NotNull
    public static final <T extends View> T applyRecursively(@NotNull T t, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        AnkoInternals.INSTANCE.applyRecursively(t, function1);
        return t;
    }
}
