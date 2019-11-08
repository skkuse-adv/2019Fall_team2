package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LockFreeMPSCQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final Companion Companion = new Companion(null);
    public static final int INITIAL_CAPACITY = 8;
    @NotNull
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicLongFieldUpdater _state$FU;
    private volatile Object _next = null;
    private volatile long _state = 0;
    private final AtomicReferenceArray<Object> array;
    private final int capacity;
    private final int mask;

    public static final class Companion {
        /* access modifiers changed from: private */
        public final int addFailReason(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* access modifiers changed from: private */
        public final long wo(long j, long j2) {
            return j & (j2 ^ -1);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final long updateHead(long j, int i) {
            return wo(j, 1073741823) | (((long) i) << 0);
        }

        /* access modifiers changed from: private */
        public final long updateTail(long j, int i) {
            return wo(j, 1152921503533105152L) | (((long) i) << 30);
        }

        /* access modifiers changed from: private */
        public final <T> T withState(long j, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) ((1073741823 & j) >> 0)), Integer.valueOf((int) ((j & 1152921503533105152L) >> 30)));
        }
    }

    private static final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeMPSCQueueCore(int i) {
        this.capacity = i;
        int i2 = this.capacity;
        this.mask = i2 - 1;
        this.array = new AtomicReferenceArray<>(i2);
        boolean z = false;
        String str = "Check failed.";
        if (this.mask <= 1073741823) {
            if ((this.capacity & this.mask) == 0) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException(str.toString());
            }
            return;
        }
        throw new IllegalStateException(str.toString());
    }

    public final boolean isEmpty() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    private final LockFreeMPSCQueueCore<E> fillPlaceholder(int i, E e) {
        Object obj = this.array.get(this.mask & i);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i) {
            return null;
        }
        this.array.set(i & this.mask, e);
        return this;
    }

    @NotNull
    public final LockFreeMPSCQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final LockFreeMPSCQueueCore<E> allocateNextCopy(long j) {
        LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = new LockFreeMPSCQueueCore<>(this.capacity * 2);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) != (i2 & i3)) {
                AtomicReferenceArray<Object> atomicReferenceArray = lockFreeMPSCQueueCore.array;
                int i4 = lockFreeMPSCQueueCore.mask & i;
                Object obj = this.array.get(i3 & i);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                atomicReferenceArray.set(i4, obj);
                i++;
            } else {
                lockFreeMPSCQueueCore._state = Companion.wo(j, 1152921504606846976L);
                return lockFreeMPSCQueueCore;
            }
        }
    }

    static {
        Class<LockFreeMPSCQueueCore> cls = LockFreeMPSCQueueCore.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        _state$FU = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public final boolean close() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!_state$FU.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int addLast(@NotNull E e) {
        long j;
        Companion companion;
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(e, "element");
        do {
            j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return Companion.addFailReason(j);
            }
            companion = Companion;
            int i3 = (int) ((1073741823 & j) >> 0);
            i = (int) ((1152921503533105152L & j) >> 30);
            int i4 = i + 2;
            int i5 = this.mask;
            if ((i4 & i5) == (i3 & i5)) {
                return 1;
            }
            i2 = (i + 1) & 1073741823;
        } while (!_state$FU.compareAndSet(this, j, companion.updateTail(j, i2)));
        this.array.set(this.mask & i, e);
        LockFreeMPSCQueueCore lockFreeMPSCQueueCore = this;
        while ((lockFreeMPSCQueueCore._state & 1152921504606846976L) != 0) {
            lockFreeMPSCQueueCore = lockFreeMPSCQueueCore.next().fillPlaceholder(i, e);
            if (lockFreeMPSCQueueCore == null) {
                break;
            }
        }
        return 0;
    }

    @Nullable
    public final Object removeFirstOrNull() {
        long j = this._state;
        if ((1152921504606846976L & j) != 0) {
            return REMOVE_FROZEN;
        }
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        int i3 = this.mask;
        if ((i2 & i3) == (i & i3)) {
            return null;
        }
        Object obj = this.array.get(i3 & i);
        if (obj == null || (obj instanceof Placeholder)) {
            return null;
        }
        int i4 = (i + 1) & 1073741823;
        if (_state$FU.compareAndSet(this, j, Companion.updateHead(j, i4))) {
            this.array.set(this.mask & i, null);
            return obj;
        }
        LockFreeMPSCQueueCore lockFreeMPSCQueueCore = this;
        do {
            lockFreeMPSCQueueCore = lockFreeMPSCQueueCore.removeSlowPath(i, i4);
        } while (lockFreeMPSCQueueCore != null);
        return obj;
    }

    private final LockFreeMPSCQueueCore<E> removeSlowPath(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            boolean z = false;
            i3 = (int) ((1073741823 & j) >> 0);
            if (i3 == i) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("This queue can have only one consumer".toString());
            } else if ((1152921504606846976L & j) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j, Companion.updateHead(j, i2)));
        this.array.set(this.mask & i3, null);
        return null;
    }

    private final long markFrozen() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!_state$FU.compareAndSet(this, j, j2));
        return j2;
    }

    private final LockFreeMPSCQueueCore<E> allocateOrGetNextCopy(long j) {
        while (true) {
            LockFreeMPSCQueueCore<E> lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) this._next;
            if (lockFreeMPSCQueueCore != null) {
                return lockFreeMPSCQueueCore;
            }
            _next$FU.compareAndSet(this, null, allocateNextCopy(j));
        }
    }
}
