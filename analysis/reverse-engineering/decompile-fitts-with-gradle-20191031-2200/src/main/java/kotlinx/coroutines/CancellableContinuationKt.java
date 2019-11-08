package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

public final class CancellableContinuationKt {
    public static final void removeOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        cancellableContinuation.invokeOnCancellation(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull DisposableHandle disposableHandle) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(disposableHandle, "handle");
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }
}
