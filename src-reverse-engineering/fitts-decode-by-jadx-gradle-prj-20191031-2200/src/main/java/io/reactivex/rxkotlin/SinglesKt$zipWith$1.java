package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.functions.Function2;

public final class SinglesKt$zipWith$1<T1, T2, R> implements BiFunction<T, U, R> {
    final /* synthetic */ Function2 $zipper;

    public SinglesKt$zipWith$1(Function2 function2) {
        this.$zipper = function2;
    }

    public final R apply(T t, U u) {
        return this.$zipper.invoke(t, u);
    }
}
