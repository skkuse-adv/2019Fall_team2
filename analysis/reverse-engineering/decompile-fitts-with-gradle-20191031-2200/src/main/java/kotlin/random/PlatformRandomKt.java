package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PlatformRandomKt {
    @NotNull
    public static final Random asJavaRandom(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "receiver$0");
        AbstractPlatformRandom abstractPlatformRandom = (AbstractPlatformRandom) (!(random instanceof AbstractPlatformRandom) ? null : random);
        if (abstractPlatformRandom != null) {
            Random impl = abstractPlatformRandom.getImpl();
            if (impl != null) {
                return impl;
            }
        }
        return new KotlinRandom(random);
    }

    @NotNull
    public static final Random asKotlinRandom(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "receiver$0");
        KotlinRandom kotlinRandom = (KotlinRandom) (!(random instanceof KotlinRandom) ? null : random);
        if (kotlinRandom != null) {
            Random impl = kotlinRandom.getImpl();
            if (impl != null) {
                return impl;
            }
        }
        return new PlatformRandom(random);
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final double doubleFromParts(int i, int i2) {
        double d = (double) ((((long) i) << 27) + ((long) i2));
        double d2 = (double) 9007199254740992L;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }
}
