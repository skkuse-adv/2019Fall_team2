package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;
import org.jetbrains.annotations.NotNull;

final class ArrayBooleanIterator extends BooleanIterator {
    private final boolean[] array;
    private int index;

    public ArrayBooleanIterator(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "array");
        this.array = zArr;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
