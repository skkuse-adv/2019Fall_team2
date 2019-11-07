package org.jetbrains.anko.coroutines.experimental;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class WeakReferenceSupportKt {
    @NotNull
    public static final <T> Ref<T> asReference(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        return new Ref<>(t);
    }
}
