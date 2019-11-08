package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return getNext() == this;
    }

    public final boolean remove() {
        throw new UnsupportedOperationException();
    }

    @NotNull
    public final Void describeRemove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$kotlinx_coroutines_core() {
        Object next = getNext();
        String str = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */";
        if (next != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = this;
            while (!Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) this)) {
                LockFreeLinkedListNode nextNode = lockFreeLinkedListNode.getNextNode();
                lockFreeLinkedListNode.validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode2, nextNode);
                lockFreeLinkedListNode2 = lockFreeLinkedListNode;
                lockFreeLinkedListNode = nextNode;
            }
            Object next2 = getNext();
            if (next2 != null) {
                validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode2, (LockFreeLinkedListNode) next2);
                return;
            }
            throw new TypeCastException(str);
        }
        throw new TypeCastException(str);
    }
}
