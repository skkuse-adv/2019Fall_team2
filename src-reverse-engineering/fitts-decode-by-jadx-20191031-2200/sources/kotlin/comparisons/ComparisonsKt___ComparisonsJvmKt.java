package kotlin.comparisons;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "a");
        Intrinsics.checkParameterIsNotNull(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkParameterIsNotNull(t, "a");
        Intrinsics.checkParameterIsNotNull(t2, "b");
        Intrinsics.checkParameterIsNotNull(t3, "c");
        return maxOf(t, maxOf(t2, t3));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "a");
        Intrinsics.checkParameterIsNotNull(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkParameterIsNotNull(t, "a");
        Intrinsics.checkParameterIsNotNull(t2, "b");
        Intrinsics.checkParameterIsNotNull(t3, "c");
        return minOf(t, minOf(t2, t3));
    }
}
