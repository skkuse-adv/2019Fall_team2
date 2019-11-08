package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompletedExceptionallyKt {
    @Nullable
    public static final <T> Object toState(@NotNull Object obj) {
        if (Result.m7isSuccessimpl(obj)) {
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        Throwable r1 = Result.m4exceptionOrNullimpl(obj);
        if (r1 == null) {
            Intrinsics.throwNpe();
        }
        return new CompletedExceptionally(r1);
    }
}
