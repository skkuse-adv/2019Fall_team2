package kotlin.random;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    FallbackThreadLocalRandom$implStorage$1() {
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Random initialValue() {
        return new Random();
    }
}
