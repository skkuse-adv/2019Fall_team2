package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DropWhileSequence<T> implements Sequence<T> {
    /* access modifiers changed from: private */
    public final Function1<T, Boolean> predicate;
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;

    public DropWhileSequence(@NotNull Sequence<? extends T> sequence2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        this.sequence = sequence2;
        this.predicate = function1;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new DropWhileSequence$iterator$1(this);
    }
}
