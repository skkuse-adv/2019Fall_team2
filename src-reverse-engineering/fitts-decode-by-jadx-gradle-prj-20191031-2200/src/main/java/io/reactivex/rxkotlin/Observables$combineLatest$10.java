package io.reactivex.rxkotlin;

import io.reactivex.functions.Function9;

public final class Observables$combineLatest$10<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
    final /* synthetic */ kotlin.jvm.functions.Function9 $combineFunction;

    public Observables$combineLatest$10(kotlin.jvm.functions.Function9 function9) {
        this.$combineFunction = function9;
    }

    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        return this.$combineFunction.invoke(t1, t2, t3, t4, t5, t6, t7, t8, t9);
    }
}
