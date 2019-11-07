package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class TransformingSequence<T, R> implements Sequence<R> {
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;
    /* access modifiers changed from: private */
    public final Function1<T, R> transformer;

    public TransformingSequence(@NotNull Sequence<? extends T> sequence2, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        Intrinsics.checkParameterIsNotNull(function1, "transformer");
        this.sequence = sequence2;
        this.transformer = function1;
    }

    @NotNull
    public Iterator<R> iterator() {
        return new TransformingSequence$iterator$1(this);
    }

    @NotNull
    public final <E> Sequence<E> flatten$kotlin_stdlib(@NotNull Function1<? super R, ? extends Iterator<? extends E>> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "iterator");
        return new FlatteningSequence(this.sequence, this.transformer, function1);
    }
}
