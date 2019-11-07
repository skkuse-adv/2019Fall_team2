package kotlin;

import kotlin.Result.Failure;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ResultKt {
    @NotNull
    public static final Object createFailure(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        return new Failure(th);
    }

    public static final void throwOnFailure(@NotNull Object obj) {
        if (obj instanceof Failure) {
            throw ((Failure) obj).exception;
        }
    }
}
