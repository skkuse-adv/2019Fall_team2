package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class CompletedExceptionally {
    @NotNull
    public final Throwable cause;

    public CompletedExceptionally(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        this.cause = th;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DebugKt.getClassSimpleName(this));
        sb.append('[');
        sb.append(this.cause);
        sb.append(']');
        return sb.toString();
    }
}
