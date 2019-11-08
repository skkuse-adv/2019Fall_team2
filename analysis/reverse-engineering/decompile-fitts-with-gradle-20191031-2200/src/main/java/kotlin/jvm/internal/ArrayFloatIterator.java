package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;
import org.jetbrains.annotations.NotNull;

final class ArrayFloatIterator extends FloatIterator {
    private final float[] array;
    private int index;

    public ArrayFloatIterator(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "array");
        this.array = fArr;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public float nextFloat() {
        try {
            float[] fArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
