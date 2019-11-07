package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockFreeMPMCQueueNode<T> {
    static final AtomicReferenceFieldUpdater next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeMPMCQueueNode.class, Object.class, "next");
    @NotNull
    volatile Object next = null;

    public static /* synthetic */ void nextValue$annotations() {
    }

    @Nullable
    public final T getNextValue() {
        return this.next;
    }

    public final boolean nextCas(@Nullable T t, @Nullable T t2) {
        return next$FU.compareAndSet(this, t, t2);
    }
}
