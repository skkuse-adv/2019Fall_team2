package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ThreadLocalWithInitialValue<T> extends ThreadLocal<T> {
    private final Function0<T> supplier;

    public ThreadLocalWithInitialValue(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "supplier");
        this.supplier = function0;
    }

    /* access modifiers changed from: protected */
    public T initialValue() {
        return this.supplier.invoke();
    }
}
