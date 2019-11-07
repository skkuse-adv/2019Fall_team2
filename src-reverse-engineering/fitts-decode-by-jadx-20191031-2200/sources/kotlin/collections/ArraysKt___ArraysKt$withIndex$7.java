package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements Function0<DoubleIterator> {
    final /* synthetic */ double[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        this.$this_withIndex = dArr;
        super(0);
    }

    @NotNull
    public final DoubleIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
