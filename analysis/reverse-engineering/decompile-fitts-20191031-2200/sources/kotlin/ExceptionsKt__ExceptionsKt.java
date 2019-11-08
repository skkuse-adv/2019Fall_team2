package kotlin;

import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ExceptionsKt__ExceptionsKt {
    public static /* synthetic */ void stackTrace$annotations(Throwable th) {
    }

    @NotNull
    public static final StackTraceElement[] getStackTrace(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "receiver$0");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            Intrinsics.throwNpe();
        }
        return stackTrace;
    }

    public static void addSuppressed(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.checkParameterIsNotNull(th, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th2, "exception");
        PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
    }
}
