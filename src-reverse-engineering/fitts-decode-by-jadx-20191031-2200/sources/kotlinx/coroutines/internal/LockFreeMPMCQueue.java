package kotlinx.coroutines.internal;

import com.kakao.auth.StringSet;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeMPMCQueueNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockFreeMPMCQueue<T extends LockFreeMPMCQueueNode<T>> {
    private static final AtomicReferenceFieldUpdater head$FU;
    private static final AtomicReferenceFieldUpdater tail$FU;
    private volatile Object head = new LockFreeMPMCQueueNode();
    private volatile Object tail = this.head;

    static {
        Class<Object> cls = Object.class;
        Class<LockFreeMPMCQueue> cls2 = LockFreeMPMCQueue.class;
        head$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "head");
        tail$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "tail");
    }

    public static /* synthetic */ void headValue$annotations() {
    }

    public static /* synthetic */ void tailValue$annotations() {
    }

    @NotNull
    public final T getHeadValue() {
        return (LockFreeMPMCQueueNode) this.head;
    }

    @NotNull
    public final T getTailValue() {
        return (LockFreeMPMCQueueNode) this.tail;
    }

    public final boolean headCas(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "curHead");
        Intrinsics.checkParameterIsNotNull(t2, StringSet.update);
        return head$FU.compareAndSet(this, t, t2);
    }

    public final boolean tailCas(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "curTail");
        Intrinsics.checkParameterIsNotNull(t2, StringSet.update);
        return tail$FU.compareAndSet(this, t, t2);
    }

    public final boolean addLastIfPrev(@NotNull T t, @NotNull Function1<Object, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        while (true) {
            LockFreeMPMCQueueNode tailValue = getTailValue();
            LockFreeMPMCQueueNode lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) tailValue.getNextValue();
            if (lockFreeMPMCQueueNode != null) {
                tailCas(tailValue, lockFreeMPMCQueueNode);
            } else if (!((Boolean) function1.invoke(tailValue)).booleanValue()) {
                return false;
            } else {
                if (tailValue.nextCas(null, t)) {
                    tailCas(tailValue, t);
                    return true;
                }
            }
        }
    }

    @Nullable
    public final T removeFirstOrNullIf(@NotNull Function1<? super T, Boolean> function1) {
        LockFreeMPMCQueueNode headValue;
        T t;
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        do {
            headValue = getHeadValue();
            t = (LockFreeMPMCQueueNode) headValue.getNextValue();
            if (t == null || !((Boolean) function1.invoke(t)).booleanValue()) {
                return null;
            }
        } while (!headCas(headValue, t));
        return t;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final <R> R fold(R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        LockFreeMPMCQueueNode headValue = getHeadValue();
        while (true) {
            headValue = (LockFreeMPMCQueueNode) headValue.getNextValue();
            if (headValue == null) {
                return r;
            }
            r = function2.invoke(r, headValue);
        }
    }

    public final void addLast(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        while (true) {
            LockFreeMPMCQueueNode lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) this.tail;
            LockFreeMPMCQueueNode lockFreeMPMCQueueNode2 = (LockFreeMPMCQueueNode) lockFreeMPMCQueueNode.next;
            if (lockFreeMPMCQueueNode2 != null) {
                tail$FU.compareAndSet(this, lockFreeMPMCQueueNode, lockFreeMPMCQueueNode2);
            } else if (LockFreeMPMCQueueNode.next$FU.compareAndSet(lockFreeMPMCQueueNode, null, t)) {
                tail$FU.compareAndSet(this, lockFreeMPMCQueueNode, t);
                return;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        LockFreeMPMCQueueNode lockFreeMPMCQueueNode;
        T t;
        do {
            lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) this.head;
            t = (LockFreeMPMCQueueNode) lockFreeMPMCQueueNode.next;
            if (t == null) {
                return null;
            }
        } while (!head$FU.compareAndSet(this, lockFreeMPMCQueueNode, t));
        return t;
    }

    public final int getSize() {
        LockFreeMPMCQueueNode headValue = getHeadValue();
        int i = 0;
        while (true) {
            headValue = (LockFreeMPMCQueueNode) headValue.getNextValue();
            if (headValue == null) {
                return i;
            }
            i++;
        }
    }
}
