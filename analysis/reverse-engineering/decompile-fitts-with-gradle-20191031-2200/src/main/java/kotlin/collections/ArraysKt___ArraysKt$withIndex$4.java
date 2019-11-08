package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements Function0<IntIterator> {
    final /* synthetic */ int[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        this.$this_withIndex = iArr;
        super(0);
    }

    @NotNull
    public final IntIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
