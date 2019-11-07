package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

final class Singles$zip$2<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
    public static final Singles$zip$2 INSTANCE = new Singles$zip$2();

    Singles$zip$2() {
    }

    @NotNull
    public final Pair<T, U> apply(T t, U u) {
        return new Pair<>(t, u);
    }
}
