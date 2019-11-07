package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ArrayQueue<T> {
    private Object[] elements = new Object[16];
    private int head;
    private int tail;

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final void addLast(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "element");
        Object[] objArr = this.elements;
        int i = this.tail;
        objArr[i] = t;
        this.tail = (objArr.length - 1) & (i + 1);
        if (this.tail == this.head) {
            ensureCapacity();
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        int i = this.head;
        if (i == this.tail) {
            return null;
        }
        T[] tArr = this.elements;
        T t = tArr[i];
        tArr[i] = null;
        this.head = (i + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final void clear() {
        this.head = 0;
        this.tail = 0;
        this.elements = new Object[this.elements.length];
    }

    private final void ensureCapacity() {
        Object[] objArr = this.elements;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        int length2 = objArr.length;
        int i = this.head;
        int i2 = length2 - i;
        ArrayCopyKt.arraycopy(objArr, i, objArr2, 0, i2);
        ArrayCopyKt.arraycopy(this.elements, 0, objArr2, i2, this.head);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }
}
