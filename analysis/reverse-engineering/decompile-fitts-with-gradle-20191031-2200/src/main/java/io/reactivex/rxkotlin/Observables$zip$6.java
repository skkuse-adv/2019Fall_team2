package io.reactivex.rxkotlin;

import io.reactivex.functions.Function5;

public final class Observables$zip$6<T1, T2, T3, T4, T5, R> implements Function5<T1, T2, T3, T4, T5, R> {
    final /* synthetic */ kotlin.jvm.functions.Function5 $combineFunction;

    public Observables$zip$6(kotlin.jvm.functions.Function5 function5) {
        this.$combineFunction = function5;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return this.$combineFunction.invoke(t1, t2, t3, t4, t5);
    }
}
