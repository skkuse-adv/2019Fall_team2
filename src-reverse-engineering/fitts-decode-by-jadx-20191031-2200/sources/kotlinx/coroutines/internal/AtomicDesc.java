package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AtomicDesc {
    public abstract void complete(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj);

    @Nullable
    public abstract Object prepare(@NotNull AtomicOp<?> atomicOp);
}
