package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LockFreeLinkedListNode$describeRemove$1 extends AbstractAtomicDesc {
    private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
    private volatile Object _originalNext = null;
    final /* synthetic */ LockFreeLinkedListNode this$0;

    LockFreeLinkedListNode$describeRemove$1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.this$0 = lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public LockFreeLinkedListNode getAffectedNode() {
        return this.this$0;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public LockFreeLinkedListNode getOriginalNext() {
        return (LockFreeLinkedListNode) this._originalNext;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(obj, "next");
        if (obj instanceof Removed) {
            return LockFreeLinkedListKt.getALREADY_REMOVED();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        _originalNext$FU.compareAndSet(this, null, lockFreeLinkedListNode2);
        return null;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Removed updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        return lockFreeLinkedListNode2.removed();
    }

    /* access modifiers changed from: protected */
    public void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        this.this$0.finishRemove(lockFreeLinkedListNode2);
    }
}
