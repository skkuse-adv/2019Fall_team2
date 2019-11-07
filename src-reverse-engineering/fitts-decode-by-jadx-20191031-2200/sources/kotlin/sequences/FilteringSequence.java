package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FilteringSequence<T> implements Sequence<T> {
    /* access modifiers changed from: private */
    public final Function1<T, Boolean> predicate;
    /* access modifiers changed from: private */
    public final boolean sendWhen;
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;

    public FilteringSequence(@NotNull Sequence<? extends T> sequence2, boolean z, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        this.sequence = sequence2;
        this.sendWhen = z;
        this.predicate = function1;
    }

    public /* synthetic */ FilteringSequence(Sequence sequence2, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            z = true;
        }
        this(sequence2, z, function1);
    }

    @NotNull
    public Iterator<T> iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
