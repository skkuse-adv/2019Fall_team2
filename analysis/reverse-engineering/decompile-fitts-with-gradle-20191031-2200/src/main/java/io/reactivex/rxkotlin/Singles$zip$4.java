package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;

final class Singles$zip$4<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
    public static final Singles$zip$4 INSTANCE = new Singles$zip$4();

    Singles$zip$4() {
    }

    @NotNull
    public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
        return new Triple<>(t1, t2, t3);
    }
}