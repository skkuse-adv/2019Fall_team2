package org.jetbrains.anko;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AnkoAsyncContext<T> {
    @NotNull
    private final WeakReference<T> weakRef;

    public AnkoAsyncContext(@NotNull WeakReference<T> weakReference) {
        Intrinsics.checkParameterIsNotNull(weakReference, "weakRef");
        this.weakRef = weakReference;
    }

    @NotNull
    public final WeakReference<T> getWeakRef() {
        return this.weakRef;
    }
}
