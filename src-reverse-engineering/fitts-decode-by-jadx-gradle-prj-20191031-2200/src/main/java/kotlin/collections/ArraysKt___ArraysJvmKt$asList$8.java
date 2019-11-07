package kotlin.collections;

import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysJvmKt$asList$8 extends AbstractList<Character> implements RandomAccess {
    final /* synthetic */ char[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$8(char[] cArr) {
        this.$this_asList = cArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Character) {
            return contains(((Character) obj).charValue());
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Character) {
            return indexOf(((Character) obj).charValue());
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return lastIndexOf(((Character) obj).charValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(char c) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, c);
    }

    @NotNull
    public Character get(int i) {
        return Character.valueOf(this.$this_asList[i]);
    }

    public int indexOf(char c) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, c);
    }

    public int lastIndexOf(char c) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, c);
    }
}
