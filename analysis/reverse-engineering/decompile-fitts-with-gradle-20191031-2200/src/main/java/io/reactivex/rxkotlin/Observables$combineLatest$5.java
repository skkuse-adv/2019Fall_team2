package io.reactivex.rxkotlin;

import io.reactivex.functions.Function4;

public final class Observables$combineLatest$5<T1, T2, T3, T4, R> implements Function4<T1, T2, T3, T4, R> {
    final /* synthetic */ kotlin.jvm.functions.Function4 $combineFunction;

    public Observables$combineLatest$5(kotlin.jvm.functions.Function4 function4) {
        this.$combineFunction = function4;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
        return this.$combineFunction.invoke(t1, t2, t3, t4);
    }
}
