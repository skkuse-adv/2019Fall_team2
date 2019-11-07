package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

public final class ComparisonsKt__ComparisonsKt$compareByDescending$1<T> implements Comparator<T> {
    final /* synthetic */ Function1 $selector;

    public ComparisonsKt__ComparisonsKt$compareByDescending$1(Function1 function1) {
        this.$selector = function1;
    }

    public final int compare(T t, T t2) {
        return ComparisonsKt__ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t2), (Comparable) this.$selector.invoke(t));
    }
}
