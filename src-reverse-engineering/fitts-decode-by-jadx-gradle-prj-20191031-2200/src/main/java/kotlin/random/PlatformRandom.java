package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class PlatformRandom extends AbstractPlatformRandom {
    @NotNull
    private final Random impl;

    public PlatformRandom(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "impl");
        this.impl = random;
    }

    @NotNull
    public Random getImpl() {
        return this.impl;
    }
}
