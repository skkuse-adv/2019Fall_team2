package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

final class SinglesKt$zipWith$2<T1, T2, R> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
    public static final SinglesKt$zipWith$2 INSTANCE = new SinglesKt$zipWith$2();

    SinglesKt$zipWith$2() {
    }

    @NotNull
    public final Pair<T, U> apply(T t, U u) {
        return new Pair<>(t, u);
    }
}
