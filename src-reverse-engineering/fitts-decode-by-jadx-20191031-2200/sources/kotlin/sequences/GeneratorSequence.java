package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class GeneratorSequence<T> implements Sequence<T> {
    /* access modifiers changed from: private */
    public final Function0<T> getInitialValue;
    /* access modifiers changed from: private */
    public final Function1<T, T> getNextValue;

    public GeneratorSequence(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "getInitialValue");
        Intrinsics.checkParameterIsNotNull(function1, "getNextValue");
        this.getInitialValue = function0;
        this.getNextValue = function1;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
