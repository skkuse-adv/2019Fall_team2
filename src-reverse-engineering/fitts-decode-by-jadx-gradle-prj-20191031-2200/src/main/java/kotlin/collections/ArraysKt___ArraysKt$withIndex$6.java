package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$6 extends Lambda implements Function0<FloatIterator> {
    final /* synthetic */ float[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$6(float[] fArr) {
        this.$this_withIndex = fArr;
        super(0);
    }

    @NotNull
    public final FloatIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
