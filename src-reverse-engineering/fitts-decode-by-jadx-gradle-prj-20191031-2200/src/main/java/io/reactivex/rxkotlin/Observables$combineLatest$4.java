package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;

final class Observables$combineLatest$4<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
    public static final Observables$combineLatest$4 INSTANCE = new Observables$combineLatest$4();

    Observables$combineLatest$4() {
    }

    @NotNull
    public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
        return new Triple<>(t1, t2, t3);
    }
}
