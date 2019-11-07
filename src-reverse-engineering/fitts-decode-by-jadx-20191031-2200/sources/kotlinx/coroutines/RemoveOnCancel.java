package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class RemoveOnCancel extends CancelHandler {
    private final LockFreeLinkedListNode node;

    public RemoveOnCancel(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        this.node = lockFreeLinkedListNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void invoke(@Nullable Throwable th) {
        this.node.remove();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveOnCancel[");
        sb.append(this.node);
        sb.append(']');
        return sb.toString();
    }
}
