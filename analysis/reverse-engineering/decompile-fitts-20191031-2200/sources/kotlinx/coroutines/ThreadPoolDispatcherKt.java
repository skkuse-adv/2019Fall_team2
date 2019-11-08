package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ThreadPoolDispatcherKt {
    @NotNull
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return newFixedThreadPoolContext(1, str);
    }

    @NotNull
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            return new ThreadPoolDispatcher(i, str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected at least one thread, but ");
        sb.append(i);
        sb.append(" specified");
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
