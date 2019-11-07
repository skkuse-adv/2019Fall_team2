package kotlinx.coroutines.internal;

import org.jetbrains.annotations.Nullable;

public abstract class OpDescriptor {
    @Nullable
    public abstract Object perform(@Nullable Object obj);
}
