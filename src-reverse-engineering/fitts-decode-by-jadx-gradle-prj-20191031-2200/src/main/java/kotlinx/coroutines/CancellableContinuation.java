package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CancellableContinuation<T> extends Continuation<T> {
    boolean cancel(@Nullable Throwable th);

    void completeResume(@NotNull Object obj);

    void initCancellability();

    void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t);

    void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th);

    @Nullable
    Object tryResume(T t, @Nullable Object obj);

    @Nullable
    Object tryResumeWithException(@NotNull Throwable th);
}
