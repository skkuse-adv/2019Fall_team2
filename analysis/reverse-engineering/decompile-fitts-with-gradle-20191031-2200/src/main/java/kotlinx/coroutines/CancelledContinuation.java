package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CancelledContinuation extends CompletedExceptionally {
    public CancelledContinuation(@NotNull Continuation<?> continuation, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        if (th == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Continuation ");
            sb.append(continuation);
            sb.append(" was cancelled normally");
            th = new CancellationException(sb.toString());
        }
        super(th);
    }
}
