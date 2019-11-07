package io.reactivex.rxkotlin;

import io.reactivex.functions.Function6;

public final class Observables$combineLatest$7<T1, T2, T3, T4, T5, T6, R> implements Function6<T1, T2, T3, T4, T5, T6, R> {
    final /* synthetic */ kotlin.jvm.functions.Function6 $combineFunction;

    public Observables$combineLatest$7(kotlin.jvm.functions.Function6 function6) {
        this.$combineFunction = function6;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return this.$combineFunction.invoke(t1, t2, t3, t4, t5, t6);
    }
}
