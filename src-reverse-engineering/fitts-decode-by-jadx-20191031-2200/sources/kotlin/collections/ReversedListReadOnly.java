package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ReversedListReadOnly<T> extends AbstractList<T> {
    private final List<T> delegate;

    public ReversedListReadOnly(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "delegate");
        this.delegate = list;
    }

    public int getSize() {
        return this.delegate.size();
    }

    public T get(int i) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i));
    }
}
