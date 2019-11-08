package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$4 extends AbstractList<Long> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$4(long[] jArr) {
        this.$this_asList = jArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Long) {
            return contains(((Number) obj).longValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Long) {
            return indexOf(((Number) obj).longValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Long) {
            return lastIndexOf(((Number) obj).longValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(long j) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, j);
    }

    @NotNull
    public Long get(int i) {
        return Long.valueOf(this.$this_asList[i]);
    }

    public int indexOf(long j) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, j);
    }

    public int lastIndexOf(long j) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, j);
    }
}
