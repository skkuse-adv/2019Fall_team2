package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

public final class ComparisonsKt__ComparisonsKt$compareBy$2<T> implements Comparator<T> {
    final /* synthetic */ Function1 $selector;

    public ComparisonsKt__ComparisonsKt$compareBy$2(Function1 function1) {
        this.$selector = function1;
    }

    public final int compare(T t, T t2) {
        return ComparisonsKt__ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), (Comparable) this.$selector.invoke(t2));
    }
}
