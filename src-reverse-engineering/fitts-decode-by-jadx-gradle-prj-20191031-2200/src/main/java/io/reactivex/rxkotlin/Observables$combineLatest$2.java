package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

final class Observables$combineLatest$2<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public static final Observables$combineLatest$2 INSTANCE = new Observables$combineLatest$2();

    Observables$combineLatest$2() {
    }

    @NotNull
    public final Pair<T1, T2> apply(T1 t1, T2 t2) {
        return TuplesKt.to(t1, t2);
    }
}
