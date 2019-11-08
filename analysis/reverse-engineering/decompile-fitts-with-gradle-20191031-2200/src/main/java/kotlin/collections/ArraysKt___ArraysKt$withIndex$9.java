package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$9 extends Lambda implements Function0<CharIterator> {
    final /* synthetic */ char[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$9(char[] cArr) {
        this.$this_withIndex = cArr;
        super(0);
    }

    @NotNull
    public final CharIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
