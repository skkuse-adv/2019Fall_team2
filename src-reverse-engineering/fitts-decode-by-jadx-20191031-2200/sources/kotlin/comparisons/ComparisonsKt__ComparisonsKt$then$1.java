package kotlin.comparisons;

import java.util.Comparator;

final class ComparisonsKt__ComparisonsKt$then$1<T> implements Comparator<T> {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Comparator $this_then;

    ComparisonsKt__ComparisonsKt$then$1(Comparator comparator, Comparator comparator2) {
        this.$this_then = comparator;
        this.$comparator = comparator2;
    }

    public final int compare(T t, T t2) {
        int compare = this.$this_then.compare(t, t2);
        return compare != 0 ? compare : this.$comparator.compare(t, t2);
    }
}
