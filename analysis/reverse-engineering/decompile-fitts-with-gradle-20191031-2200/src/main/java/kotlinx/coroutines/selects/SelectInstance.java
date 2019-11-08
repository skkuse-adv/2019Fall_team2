package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SelectInstance<R> {
    void disposeOnSelect(@NotNull DisposableHandle disposableHandle);

    @NotNull
    Continuation<R> getCompletion();

    boolean isSelected();

    @Nullable
    Object performAtomicIfNotSelected(@NotNull AtomicDesc atomicDesc);

    @Nullable
    Object performAtomicTrySelect(@NotNull AtomicDesc atomicDesc);

    void resumeSelectCancellableWithException(@NotNull Throwable th);

    boolean trySelect(@Nullable Object obj);
}
