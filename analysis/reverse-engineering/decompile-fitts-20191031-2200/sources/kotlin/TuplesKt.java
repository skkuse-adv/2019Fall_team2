package kotlin;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class TuplesKt {
    @NotNull
    public static final <A, B> Pair<A, B> to(A a, B b) {
        return new Pair<>(a, b);
    }

    @NotNull
    public static final <T> List<T> toList(@NotNull Pair<? extends T, ? extends T> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "receiver$0");
        return CollectionsKt__CollectionsKt.listOf(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <T> List<T> toList(@NotNull Triple<? extends T, ? extends T, ? extends T> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "receiver$0");
        return CollectionsKt__CollectionsKt.listOf(triple.getFirst(), triple.getSecond(), triple.getThird());
    }
}
