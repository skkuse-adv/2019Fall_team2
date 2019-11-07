package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.Nullable;

public abstract class AtomicOp<T> extends OpDescriptor {
    private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T t, @Nullable Object obj);

    @Nullable
    public abstract Object prepare(T t);

    public final boolean isDecided() {
        return this._consensus != AtomicKt.NO_DECISION;
    }

    public final boolean tryDecide(@Nullable Object obj) {
        if (obj != AtomicKt.NO_DECISION) {
            return _consensus$FU.compareAndSet(this, AtomicKt.NO_DECISION, obj);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final Object decide(Object obj) {
        return tryDecide(obj) ? obj : this._consensus;
    }

    @Nullable
    public final Object perform(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == AtomicKt.NO_DECISION) {
            obj2 = decide(prepare(obj));
        }
        complete(obj, obj2);
        return obj2;
    }
}
