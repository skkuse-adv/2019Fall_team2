package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

public final class CompletedContinuation implements Continuation<Object> {
    public static final CompletedContinuation INSTANCE = new CompletedContinuation();

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }

    private CompletedContinuation() {
    }

    @NotNull
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
