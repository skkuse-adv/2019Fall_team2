package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;

public final class Observables$combineLatest$3<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {
    final /* synthetic */ kotlin.jvm.functions.Function3 $combineFunction;

    public Observables$combineLatest$3(kotlin.jvm.functions.Function3 function3) {
        this.$combineFunction = function3;
    }

    public final R apply(T1 t1, T2 t2, T3 t3) {
        return this.$combineFunction.invoke(t1, t2, t3);
    }
}
