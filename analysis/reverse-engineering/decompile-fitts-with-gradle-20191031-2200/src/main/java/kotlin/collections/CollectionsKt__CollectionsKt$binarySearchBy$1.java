package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ Function1 $selector;

    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1 function1, Comparable comparable) {
        this.$selector = function1;
        this.$key = comparable;
        super(1);
    }

    public final int invoke(T t) {
        return ComparisonsKt__ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), this.$key);
    }
}
