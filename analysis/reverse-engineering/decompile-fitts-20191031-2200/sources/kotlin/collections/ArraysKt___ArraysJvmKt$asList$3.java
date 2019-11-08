package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ int[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$3(int[] iArr) {
        this.$this_asList = iArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains(((Number) obj).intValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf(((Number) obj).intValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf(((Number) obj).intValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(int i) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, i);
    }

    @NotNull
    public Integer get(int i) {
        return Integer.valueOf(this.$this_asList[i]);
    }

    public int indexOf(int i) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, i);
    }

    public int lastIndexOf(int i) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, i);
    }
}
