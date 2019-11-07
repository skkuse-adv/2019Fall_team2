package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class KotlinRandom extends Random {
    @NotNull
    private final Random impl;

    public KotlinRandom(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "impl");
        this.impl = random;
    }

    @NotNull
    public final Random getImpl() {
        return this.impl;
    }

    /* access modifiers changed from: protected */
    public int next(int i) {
        return this.impl.nextBits(i);
    }

    public int nextInt() {
        return this.impl.nextInt();
    }

    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }

    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    public long nextLong() {
        return this.impl.nextLong();
    }

    public float nextFloat() {
        return this.impl.nextFloat();
    }

    public double nextDouble() {
        return this.impl.nextDouble();
    }

    public void nextBytes(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "bytes");
        this.impl.nextBytes(bArr);
    }

    public void setSeed(long j) {
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}
