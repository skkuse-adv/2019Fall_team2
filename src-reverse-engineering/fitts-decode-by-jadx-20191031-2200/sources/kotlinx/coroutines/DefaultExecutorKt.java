package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public final class DefaultExecutorKt {
    @NotNull
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    @NotNull
    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
