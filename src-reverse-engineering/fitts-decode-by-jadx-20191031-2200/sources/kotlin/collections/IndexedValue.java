package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IndexedValue<T> {
    private final int index;
    private final T value;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=T, for r2v0, types: [java.lang.Object] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kotlin.collections.IndexedValue copy$default(kotlin.collections.IndexedValue r0, int r1, T r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            int r1 = r0.index
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            T r2 = r0.value
        L_0x000c:
            kotlin.collections.IndexedValue r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.IndexedValue.copy$default(kotlin.collections.IndexedValue, int, java.lang.Object, int, java.lang.Object):kotlin.collections.IndexedValue");
    }

    public final int component1() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    @NotNull
    public final IndexedValue<T> copy(int i, T t) {
        return new IndexedValue<>(i, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof IndexedValue) {
                IndexedValue indexedValue = (IndexedValue) obj;
                if (!(this.index == indexedValue.index) || !Intrinsics.areEqual((Object) this.value, (Object) indexedValue.value)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.index * 31;
        T t = this.value;
        return i + (t != null ? t.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndexedValue(index=");
        sb.append(this.index);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(")");
        return sb.toString();
    }

    public IndexedValue(int i, T t) {
        this.index = i;
        this.value = t;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }
}
