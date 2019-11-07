package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$5 extends Lambda implements Function0<LongIterator> {
    final /* synthetic */ long[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$5(long[] jArr) {
        this.$this_withIndex = jArr;
        super(0);
    }

    @NotNull
    public final LongIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
