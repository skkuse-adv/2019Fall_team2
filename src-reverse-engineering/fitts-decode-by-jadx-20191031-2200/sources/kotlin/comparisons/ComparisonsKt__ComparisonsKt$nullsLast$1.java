package kotlin.comparisons;

import java.util.Comparator;
import org.jetbrains.annotations.Nullable;

final class ComparisonsKt__ComparisonsKt$nullsLast$1<T> implements Comparator<T> {
    final /* synthetic */ Comparator $comparator;

    ComparisonsKt__ComparisonsKt$nullsLast$1(Comparator comparator) {
        this.$comparator = comparator;
    }

    public final int compare(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.$comparator.compare(t, t2);
    }
}
