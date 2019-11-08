package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ReversedList<T> extends AbstractMutableList<T> {
    private final List<T> delegate;

    public ReversedList(@NotNull List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "delegate");
        this.delegate = list;
    }

    public int getSize() {
        return this.delegate.size();
    }

    public T get(int i) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i));
    }

    public void clear() {
        this.delegate.clear();
    }

    public T removeAt(int i) {
        return this.delegate.remove(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i));
    }

    public T set(int i, T t) {
        return this.delegate.set(CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, i), t);
    }

    public void add(int i, T t) {
        this.delegate.add(CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(this, i), t);
    }
}
