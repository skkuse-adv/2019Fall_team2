package io.reactivex.rxkotlin;

import io.reactivex.functions.Function7;

public final class Singles$zip$8<T1, T2, T3, T4, T5, T6, T7, R> implements Function7<T1, T2, T3, T4, T5, T6, T7, R> {
    final /* synthetic */ kotlin.jvm.functions.Function7 $zipper;

    public Singles$zip$8(kotlin.jvm.functions.Function7 function7) {
        this.$zipper = function7;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return this.$zipper.invoke(t1, t2, t3, t4, t5, t6, t7);
    }
}
