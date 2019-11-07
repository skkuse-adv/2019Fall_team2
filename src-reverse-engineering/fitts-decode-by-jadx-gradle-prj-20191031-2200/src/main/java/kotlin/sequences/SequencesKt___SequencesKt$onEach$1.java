package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements Function1<T, T> {
    final /* synthetic */ Function1 $action;

    SequencesKt___SequencesKt$onEach$1(Function1 function1) {
        this.$action = function1;
        super(1);
    }

    public final T invoke(T t) {
        this.$action.invoke(t);
        return t;
    }
}
