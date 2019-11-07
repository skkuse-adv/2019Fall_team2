package kotlin.coroutines;

import org.jetbrains.annotations.NotNull;

public interface Continuation<T> {
    @NotNull
    CoroutineContext getContext();

    void resumeWith(@NotNull Object obj);
}
