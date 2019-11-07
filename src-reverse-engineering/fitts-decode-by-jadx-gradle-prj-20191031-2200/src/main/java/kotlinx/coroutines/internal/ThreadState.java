package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ThreadState {
    private Object[] a;
    @NotNull
    private final CoroutineContext context;
    private int i;

    public ThreadState(@NotNull CoroutineContext coroutineContext, int i2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
        this.a = new Object[i2];
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    public final void append(@Nullable Object obj) {
        Object[] objArr = this.a;
        int i2 = this.i;
        this.i = i2 + 1;
        objArr[i2] = obj;
    }

    @Nullable
    public final Object take() {
        Object[] objArr = this.a;
        int i2 = this.i;
        this.i = i2 + 1;
        return objArr[i2];
    }

    public final void start() {
        this.i = 0;
    }
}
