package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPlatformRandom extends Random {
    @NotNull
    public abstract Random getImpl();

    public int nextBits(int i) {
        return RandomKt.takeUpperBits(getImpl().nextInt(), i);
    }

    public int nextInt() {
        return getImpl().nextInt();
    }

    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }

    public long nextLong() {
        return getImpl().nextLong();
    }

    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    public double nextDouble() {
        return getImpl().nextDouble();
    }

    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }
}
