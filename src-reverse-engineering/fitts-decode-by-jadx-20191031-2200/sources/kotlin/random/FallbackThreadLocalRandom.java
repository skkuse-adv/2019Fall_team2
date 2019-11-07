package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    private final FallbackThreadLocalRandom$implStorage$1 implStorage = new FallbackThreadLocalRandom$implStorage$1();

    @NotNull
    public Random getImpl() {
        Object obj = this.implStorage.get();
        Intrinsics.checkExpressionValueIsNotNull(obj, "implStorage.get()");
        return (Random) obj;
    }
}
