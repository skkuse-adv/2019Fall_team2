package io.reactivex.rxkotlin;

import io.reactivex.functions.Function8;

public final class Observables$combineLatest$9<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
    final /* synthetic */ kotlin.jvm.functions.Function8 $combineFunction;

    public Observables$combineLatest$9(kotlin.jvm.functions.Function8 function8) {
        this.$combineFunction = function8;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return this.$combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}
