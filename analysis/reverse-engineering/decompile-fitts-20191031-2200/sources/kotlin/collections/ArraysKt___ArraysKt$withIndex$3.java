package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$3 extends Lambda implements Function0<ShortIterator> {
    final /* synthetic */ short[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$3(short[] sArr) {
        this.$this_withIndex = sArr;
        super(0);
    }

    @NotNull
    public final ShortIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
