package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    final /* synthetic */ float[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$5(float[] fArr) {
        this.$this_asList = fArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Float) {
            return contains(((Number) obj).floatValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Float) {
            return indexOf(((Number) obj).floatValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            return lastIndexOf(((Number) obj).floatValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(float f) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, f);
    }

    @NotNull
    public Float get(int i) {
        return Float.valueOf(this.$this_asList[i]);
    }

    public int indexOf(float f) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, f);
    }

    public int lastIndexOf(float f) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, f);
    }
}
