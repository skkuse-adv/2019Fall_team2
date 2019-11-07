package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;
import org.jetbrains.annotations.NotNull;

final class ArrayByteIterator extends ByteIterator {
    private final byte[] array;
    private int index;

    public ArrayByteIterator(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        this.array = bArr;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public byte nextByte() {
        try {
            byte[] bArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
