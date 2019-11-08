package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.functions.Function2;

public final class Observables$combineLatest$1<T1, T2, R> implements BiFunction<T1, T2, R> {
    final /* synthetic */ Function2 $combineFunction;

    public Observables$combineLatest$1(Function2 function2) {
        this.$combineFunction = function2;
    }

    public final R apply(T1 t1, T2 t2) {
        return this.$combineFunction.invoke(t1, t2);
    }
}
