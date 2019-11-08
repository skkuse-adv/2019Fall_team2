package kotlinx.coroutines;

import com.facebook.internal.ServerProtocol;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @NotNull
    public NodeList getList() {
        return this;
    }

    public boolean isActive() {
        return true;
    }

    @NotNull
    public final String getString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object next = getNext();
        if (next != null) {
            boolean z = true;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(jobNode);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @NotNull
    public String toString() {
        return getString("Active");
    }
}
