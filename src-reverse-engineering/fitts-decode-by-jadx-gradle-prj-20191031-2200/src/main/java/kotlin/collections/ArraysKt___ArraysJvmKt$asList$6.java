package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$6 extends AbstractList<Double> implements RandomAccess {
    final /* synthetic */ double[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$6(double[] dArr) {
        this.$this_asList = dArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Double) {
            return contains(((Number) obj).doubleValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Double) {
            return indexOf(((Number) obj).doubleValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Double) {
            return lastIndexOf(((Number) obj).doubleValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(double d) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, d);
    }

    @NotNull
    public Double get(int i) {
        return Double.valueOf(this.$this_asList[i]);
    }

    public int indexOf(double d) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, d);
    }

    public int lastIndexOf(double d) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, d);
    }
}
