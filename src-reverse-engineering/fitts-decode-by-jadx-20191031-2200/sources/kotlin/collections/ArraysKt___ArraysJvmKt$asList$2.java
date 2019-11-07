package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$2 extends AbstractList<Short> implements RandomAccess {
    final /* synthetic */ short[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$2(short[] sArr) {
        this.$this_asList = sArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Short) {
            return contains(((Number) obj).shortValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Short) {
            return indexOf(((Number) obj).shortValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Short) {
            return lastIndexOf(((Number) obj).shortValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(short s) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, s);
    }

    @NotNull
    public Short get(int i) {
        return Short.valueOf(this.$this_asList[i]);
    }

    public int indexOf(short s) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, s);
    }

    public int lastIndexOf(short s) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, s);
    }
}
