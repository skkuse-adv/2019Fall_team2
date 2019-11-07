package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class TransformingIndexedSequence<T, R> implements Sequence<R> {
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;
    /* access modifiers changed from: private */
    public final Function2<Integer, T, R> transformer;

    public TransformingIndexedSequence(@NotNull Sequence<? extends T> sequence2, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        Intrinsics.checkParameterIsNotNull(function2, "transformer");
        this.sequence = sequence2;
        this.transformer = function2;
    }

    @NotNull
    public Iterator<R> iterator() {
        return new TransformingIndexedSequence$iterator$1(this);
    }
}
