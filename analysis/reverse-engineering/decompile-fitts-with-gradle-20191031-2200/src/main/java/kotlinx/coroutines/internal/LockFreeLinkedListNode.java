package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockFreeLinkedListNode {
    static final AtomicReferenceFieldUpdater _next$FU;
    static final AtomicReferenceFieldUpdater _prev$FU;
    private static final AtomicReferenceFieldUpdater _removedRef$FU;
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    public static abstract class AbstractAtomicDesc extends AtomicDesc {

        private static final class PrepareOp extends OpDescriptor {
            @NotNull
            public final AbstractAtomicDesc desc;
            @NotNull
            public final LockFreeLinkedListNode next;
            @NotNull
            public final AtomicOp<LockFreeLinkedListNode> op;

            public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull AtomicOp<? super LockFreeLinkedListNode> atomicOp, @NotNull AbstractAtomicDesc abstractAtomicDesc) {
                Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "next");
                Intrinsics.checkParameterIsNotNull(atomicOp, "op");
                Intrinsics.checkParameterIsNotNull(abstractAtomicDesc, "desc");
                this.next = lockFreeLinkedListNode;
                this.op = atomicOp;
                this.desc = abstractAtomicDesc;
            }

            @Nullable
            public Object perform(@Nullable Object obj) {
                if (obj != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    Object onPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                    if (onPrepare != null) {
                        if (onPrepare == LockFreeLinkedListKt.REMOVE_PREPARED) {
                            if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next.removed())) {
                                lockFreeLinkedListNode.helpDelete();
                            }
                        } else {
                            this.op.tryDecide(onPrepare);
                            LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next);
                        }
                        return onPrepare;
                    }
                    LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.op.isDecided() ? this.next : this.op);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        @Nullable
        public abstract LockFreeLinkedListNode getAffectedNode();

        /* access modifiers changed from: protected */
        @Nullable
        public abstract LockFreeLinkedListNode getOriginalNext();

        /* access modifiers changed from: protected */
        @Nullable
        public abstract Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return false;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public abstract Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        @NotNull
        public LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                Intrinsics.throwNpe();
            }
            return affectedNode;
        }

        @Nullable
        public final Object prepare(@NotNull AtomicOp<?> atomicOp) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
                Object obj = takeAffectedNode._next;
                if (obj == atomicOp || atomicOp.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode, obj);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj)) {
                        continue;
                    } else if (obj != null) {
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) obj, atomicOp, this);
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, obj, prepareOp)) {
                            Object perform = prepareOp.perform(takeAffectedNode);
                            if (perform != LockFreeLinkedListKt.REMOVE_PREPARED) {
                                return perform;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    }
                }
            }
        }

        public final void complete(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(atomicOp, "op");
            boolean z = obj == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            String str = "Check failed.";
            if (affectedNode != null) {
                LockFreeLinkedListNode originalNext = getOriginalNext();
                if (originalNext != 0) {
                    if (LockFreeLinkedListNode._next$FU.compareAndSet(affectedNode, atomicOp, z ? updatedNext(affectedNode, originalNext) : originalNext) && z) {
                        finishOnSuccess(affectedNode, originalNext);
                    }
                } else if (!(!z)) {
                    throw new IllegalStateException(str.toString());
                }
            } else if (!(!z)) {
                throw new IllegalStateException(str.toString());
            }
        }
    }

    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode;
        @NotNull
        public final T node;
        @NotNull
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull T t) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
            Intrinsics.checkParameterIsNotNull(t, "node");
            this.queue = lockFreeLinkedListNode;
            this.node = t;
            T t2 = this.node._next;
            T t3 = this.node;
            if (t2 == t3 && t3._prev == this.node) {
                this._affectedNode = null;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        /* access modifiers changed from: protected */
        @NotNull
        public final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            while (true) {
                Object obj = this.queue._prev;
                if (obj != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    Object obj2 = lockFreeLinkedListNode._next;
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
                    if (obj2 == lockFreeLinkedListNode2 || obj2 == opDescriptor) {
                        return lockFreeLinkedListNode;
                    }
                    if (obj2 instanceof OpDescriptor) {
                        ((OpDescriptor) obj2).perform(lockFreeLinkedListNode);
                    } else {
                        LockFreeLinkedListNode access$correctPrev = lockFreeLinkedListNode2.correctPrev(lockFreeLinkedListNode, opDescriptor);
                        if (access$correctPrev != null) {
                            return access$correctPrev;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        /* access modifiers changed from: protected */
        public boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            return obj != this.queue;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            _affectedNode$FU.compareAndSet(this, null, lockFreeLinkedListNode);
            return null;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            T t = this.node;
            LockFreeLinkedListNode._prev$FU.compareAndSet(t, t, lockFreeLinkedListNode);
            T t2 = this.node;
            LockFreeLinkedListNode._next$FU.compareAndSet(t2, t2, this.queue);
            return this.node;
        }

        /* access modifiers changed from: protected */
        public void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            this.node.finishAdd(this.queue);
        }
    }

    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        @NotNull
        public final LockFreeLinkedListNode newNode;
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "newNode");
            this.newNode = lockFreeLinkedListNode;
        }

        public void complete(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                if (lockFreeLinkedListNode4 == null) {
                    Intrinsics.throwNpe();
                }
                lockFreeLinkedListNode3.finishAdd(lockFreeLinkedListNode4);
            }
        }
    }

    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU;
        private static final AtomicReferenceFieldUpdater _originalNext$FU;
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @NotNull
        public final LockFreeLinkedListNode queue;

        static {
            Class<Object> cls = Object.class;
            Class<RemoveFirstDesc> cls2 = RemoveFirstDesc.class;
            _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_affectedNode");
            _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_originalNext");
        }

        public static /* synthetic */ void result$annotations() {
        }

        /* access modifiers changed from: protected */
        public boolean validatePrepared(T t) {
            return true;
        }

        public RemoveFirstDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "queue");
            this.queue = lockFreeLinkedListNode;
        }

        public final T getResult() {
            T affectedNode = getAffectedNode();
            if (affectedNode == null) {
                Intrinsics.throwNpe();
            }
            return affectedNode;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor opDescriptor) {
            Intrinsics.checkParameterIsNotNull(opDescriptor, "op");
            Object next = this.queue.getNext();
            if (next != null) {
                return (LockFreeLinkedListNode) next;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object failure(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (lockFreeLinkedListNode == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final boolean retry(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(obj, "next");
            if (!(obj instanceof Removed)) {
                return false;
            }
            lockFreeLinkedListNode.helpDelete();
            return true;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final Object onPrepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            if (!(!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead))) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!validatePrepared(lockFreeLinkedListNode)) {
                return LockFreeLinkedListKt.REMOVE_PREPARED;
            } else {
                _affectedNode$FU.compareAndSet(this, null, lockFreeLinkedListNode);
                _originalNext$FU.compareAndSet(this, null, lockFreeLinkedListNode2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        @NotNull
        public final Object updatedNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            return lockFreeLinkedListNode2.removed();
        }

        /* access modifiers changed from: protected */
        public final void finishOnSuccess(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
            Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
            lockFreeLinkedListNode.finishRemove(lockFreeLinkedListNode2);
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<LockFreeLinkedListNode> cls2 = LockFreeLinkedListNode.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        _prev$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    /* access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        _removedRef$FU.lazySet(this, removed2);
        return removed2;
    }

    @NotNull
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        return new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object prev;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        do {
            prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!((LockFreeLinkedListNode) prev).addNext(lockFreeLinkedListNode, this));
    }

    @NotNull
    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        return new AddLastDesc<>(this, t);
    }

    public final boolean addLastIfPrev(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        do {
            Object prev = getPrev();
            if (prev != null) {
                lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                    return false;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode2.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean addNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!_next$FU.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull CondAddOp condAddOp) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        Intrinsics.checkParameterIsNotNull(condAddOp, "condAdd");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!_next$FU.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.perform(this) == null ? 1 : 2;
    }

    public boolean remove() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    public final void helpRemove() {
        Object next = getNext();
        if (!(next instanceof Removed)) {
            next = null;
        }
        Removed removed = (Removed) next;
        if (removed != null) {
            finishRemove(removed.ref);
            return;
        }
        throw new IllegalStateException("Must be invoked on a removed node".toString());
    }

    @Nullable
    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new LockFreeLinkedListNode$describeRemove$1(this);
    }

    @Nullable
    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            if (next != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                if (lockFreeLinkedListNode == this) {
                    return null;
                }
                if (lockFreeLinkedListNode.remove()) {
                    return lockFreeLinkedListNode;
                }
                lockFreeLinkedListNode.helpDelete();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    @NotNull
    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    /* access modifiers changed from: private */
    public final void finishRemove(LockFreeLinkedListNode lockFreeLinkedListNode) {
        helpDelete();
        lockFreeLinkedListNode.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode findHead() {
        boolean z;
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead)) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (lockFreeLinkedListNode != this) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return lockFreeLinkedListNode;
    }

    public final void helpDelete() {
        Object next;
        LockFreeLinkedListNode markPrev = markPrev();
        Object obj = this._next;
        if (obj != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = ((Removed) obj).ref;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
                while (true) {
                    Object next2 = lockFreeLinkedListNode.getNext();
                    if (next2 instanceof Removed) {
                        lockFreeLinkedListNode.markPrev();
                        lockFreeLinkedListNode = ((Removed) next2).ref;
                    } else {
                        next = markPrev.getNext();
                        if (next instanceof Removed) {
                            if (lockFreeLinkedListNode2 != null) {
                                break;
                            }
                            markPrev = LockFreeLinkedListKt.unwrap(markPrev._prev);
                        } else if (next != this) {
                            if (next != null) {
                                LockFreeLinkedListNode lockFreeLinkedListNode3 = (LockFreeLinkedListNode) next;
                                if (lockFreeLinkedListNode3 != lockFreeLinkedListNode) {
                                    LockFreeLinkedListNode lockFreeLinkedListNode4 = lockFreeLinkedListNode3;
                                    lockFreeLinkedListNode2 = markPrev;
                                    markPrev = lockFreeLinkedListNode4;
                                } else {
                                    return;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                            }
                        } else if (_next$FU.compareAndSet(markPrev, this, lockFreeLinkedListNode)) {
                            return;
                        }
                    }
                }
                markPrev.markPrev();
                _next$FU.compareAndSet(lockFreeLinkedListNode2, markPrev, ((Removed) next).ref);
                markPrev = lockFreeLinkedListNode2;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
    }

    /* access modifiers changed from: private */
    public final LockFreeLinkedListNode correctPrev(LockFreeLinkedListNode lockFreeLinkedListNode, OpDescriptor opDescriptor) {
        Object obj;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
            while (true) {
                obj = lockFreeLinkedListNode._next;
                if (obj == opDescriptor) {
                    return lockFreeLinkedListNode;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(lockFreeLinkedListNode);
                } else if (!(obj instanceof Removed)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof Removed) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj != null) {
                            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
                            lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    } else if (obj2 == lockFreeLinkedListNode) {
                        return null;
                    } else {
                        if (_prev$FU.compareAndSet(this, obj2, lockFreeLinkedListNode) && !(lockFreeLinkedListNode._prev instanceof Removed)) {
                            return null;
                        }
                    }
                } else if (lockFreeLinkedListNode2 != null) {
                    break;
                } else {
                    lockFreeLinkedListNode = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNode._prev);
                }
            }
            lockFreeLinkedListNode.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode2, lockFreeLinkedListNode, ((Removed) obj).ref);
            lockFreeLinkedListNode = lockFreeLinkedListNode2;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "prev");
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode2, "next");
        boolean z = true;
        String str = "Check failed.";
        if (lockFreeLinkedListNode == this._prev) {
            if (lockFreeLinkedListNode2 != this._next) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(str.toString());
            }
            return;
        }
        throw new IllegalStateException(str.toString());
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    @NotNull
    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @NotNull
    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                if (lockFreeLinkedListNode.getNext() == this) {
                    return obj;
                }
                correctPrev(lockFreeLinkedListNode, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            Object prev = getPrev();
            if (prev != null) {
                tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrevAndIf(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1, @NotNull Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Intrinsics.checkParameterIsNotNull(function0, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(function0, lockFreeLinkedListNode, lockFreeLinkedListNode);
        do {
            Object prev = getPrev();
            if (prev != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) prev;
                if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                    return false;
                }
                tryCondAddNext = lockFreeLinkedListNode2.tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    /* access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object obj;
        do {
            obj = lockFreeLinkedListNode._prev;
            if ((obj instanceof Removed) || getNext() != lockFreeLinkedListNode) {
                return;
            }
        } while (!_prev$FU.compareAndSet(lockFreeLinkedListNode, obj, this));
        if (!(getNext() instanceof Removed)) {
            return;
        }
        if (obj != null) {
            lockFreeLinkedListNode.correctPrev((LockFreeLinkedListNode) obj, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final LockFreeLinkedListNode markPrev() {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
            if (obj == this) {
                lockFreeLinkedListNode = findHead();
            } else if (obj != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!_prev$FU.compareAndSet(this, obj, lockFreeLinkedListNode.removed()));
        return (LockFreeLinkedListNode) obj;
    }
}
