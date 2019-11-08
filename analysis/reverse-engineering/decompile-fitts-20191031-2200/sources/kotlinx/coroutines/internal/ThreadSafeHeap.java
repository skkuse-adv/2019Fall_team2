package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private T[] a;
    public volatile int size;

    public static /* synthetic */ void size$annotations() {
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final synchronized void clear() {
        Arrays.fill(this.a, 0, this.size, null);
        this.size = 0;
    }

    @Nullable
    public final synchronized T peek() {
        return firstImpl();
    }

    @Nullable
    public final synchronized T removeFirstOrNull() {
        return this.size > 0 ? removeAtImpl(0) : null;
    }

    public final synchronized void addLast(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        addImpl(t);
    }

    public final synchronized boolean remove(@NotNull T t) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(t, "node");
        z = true;
        boolean z2 = false;
        if (t.getHeap() == null) {
            z = false;
        } else {
            int index = t.getIndex();
            if (index >= 0) {
                z2 = true;
            }
            if (z2) {
                removeAtImpl(index);
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return z;
    }

    @Nullable
    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public final T removeAtImpl(int i) {
        boolean z = false;
        String str = "Check failed.";
        if (this.size > 0) {
            T[] tArr = this.a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            this.size--;
            if (i < this.size) {
                swap(i, this.size);
                int i2 = (i - 1) / 2;
                if (i > 0) {
                    T t = tArr[i];
                    if (t == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i2];
                    if (t2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(t2) < 0) {
                        swap(i, i2);
                        siftUpFrom(i2);
                    }
                }
                siftDownFrom(i);
            }
            T t3 = tArr[this.size];
            if (t3 == null) {
                Intrinsics.throwNpe();
            }
            if (t3.getHeap() == this) {
                z = true;
            }
            if (z) {
                t3.setHeap(null);
                t3.setIndex(-1);
                tArr[this.size] = null;
                return t3;
            }
            throw new IllegalStateException(str.toString());
        }
        throw new IllegalStateException(str.toString());
    }

    public final void addImpl(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "node");
        if (t.getHeap() == null) {
            t.setHeap(this);
            ThreadSafeHeapNode[] realloc = realloc();
            int i = this.size;
            this.size = i + 1;
            realloc[i] = t;
            t.setIndex(i);
            siftUpFrom(i);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            if (t == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i];
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(t2) > 0) {
                swap(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 < this.size) {
                T[] tArr = this.a;
                if (tArr == null) {
                    Intrinsics.throwNpe();
                }
                int i3 = i2 + 1;
                if (i3 < this.size) {
                    T t = tArr[i3];
                    if (t == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i2];
                    if (t2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable.compareTo(t2) < 0) {
                        i2 = i3;
                    }
                }
                T t3 = tArr[i];
                if (t3 == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable2 = (Comparable) t3;
                T t4 = tArr[i2];
                if (t4 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable2.compareTo(t4) > 0) {
                    swap(i, i2);
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        } else if (this.size < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, this.size * 2);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.a = tArr3;
            return tArr3;
        }
    }

    private final void swap(int i, int i2) {
        T[] tArr = this.a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        T t = tArr[i2];
        if (t == null) {
            Intrinsics.throwNpe();
        }
        T t2 = tArr[i];
        if (t2 == null) {
            Intrinsics.throwNpe();
        }
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        synchronized (this) {
            try {
                ThreadSafeHeapNode firstImpl = firstImpl();
                T t = null;
                if (firstImpl != null) {
                    if (((Boolean) function1.invoke(firstImpl)).booleanValue()) {
                        t = removeAtImpl(0);
                    }
                    InlineMarker.finallyEnd(1);
                    return t;
                }
                InlineMarker.finallyStart(2);
                InlineMarker.finallyEnd(2);
                return null;
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final boolean addLastIf(@NotNull T t, @NotNull Function0<Boolean> function0) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(t, "node");
        Intrinsics.checkParameterIsNotNull(function0, "cond");
        synchronized (this) {
            try {
                if (((Boolean) function0.invoke()).booleanValue()) {
                    addImpl(t);
                    z = true;
                } else {
                    z = false;
                }
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }
}
