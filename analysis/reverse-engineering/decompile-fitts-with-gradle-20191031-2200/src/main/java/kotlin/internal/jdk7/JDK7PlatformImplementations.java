package kotlin.internal.jdk7;

import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class JDK7PlatformImplementations extends PlatformImplementations {
    public void addSuppressed(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        Intrinsics.checkParameterIsNotNull(th2, "exception");
        th.addSuppressed(th2);
    }
}
