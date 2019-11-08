package org.jetbrains.anko.coroutines.experimental;

import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Ref<T> {
    /* access modifiers changed from: private */
    public final WeakReference<T> weakRef;

    public Ref(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "obj");
        this.weakRef = new WeakReference<>(t);
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super T> continuation) {
        IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        Object obj = this.weakRef.get();
        if (obj != null) {
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return obj;
        }
        throw new CancellationException();
    }
}
