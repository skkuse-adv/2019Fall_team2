package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$8 extends Lambda implements Function0<BooleanIterator> {
    final /* synthetic */ boolean[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$8(boolean[] zArr) {
        this.$this_withIndex = zArr;
        super(0);
    }

    @NotNull
    public final BooleanIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
