package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends T>> {
    final /* synthetic */ Iterable $this_withIndex;

    CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        this.$this_withIndex = iterable;
        super(0);
    }

    @NotNull
    public final Iterator<T> invoke() {
        return this.$this_withIndex.iterator();
    }
}
