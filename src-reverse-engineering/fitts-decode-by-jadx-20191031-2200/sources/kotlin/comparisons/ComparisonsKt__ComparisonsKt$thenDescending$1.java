package kotlin.comparisons;

import java.util.Comparator;

final class ComparisonsKt__ComparisonsKt$thenDescending$1<T> implements Comparator<T> {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Comparator $this_thenDescending;

    ComparisonsKt__ComparisonsKt$thenDescending$1(Comparator comparator, Comparator comparator2) {
        this.$this_thenDescending = comparator;
        this.$comparator = comparator2;
    }

    public final int compare(T t, T t2) {
        int compare = this.$this_thenDescending.compare(t, t2);
        return compare != 0 ? compare : this.$comparator.compare(t2, t);
    }
}
