package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$1 extends AbstractList<Byte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$1(byte[] bArr) {
        this.$this_asList = bArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return contains(((Number) obj).byteValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return indexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return lastIndexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(byte b) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, b);
    }

    @NotNull
    public Byte get(int i) {
        return Byte.valueOf(this.$this_asList[i]);
    }

    public int indexOf(byte b) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, b);
    }

    public int lastIndexOf(byte b) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, b);
    }
}
