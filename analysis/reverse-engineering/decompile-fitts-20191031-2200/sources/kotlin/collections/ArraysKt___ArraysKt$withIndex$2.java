package kotlin.collections;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ArraysKt___ArraysKt$withIndex$2 extends Lambda implements Function0<ByteIterator> {
    final /* synthetic */ byte[] $this_withIndex;

    ArraysKt___ArraysKt$withIndex$2(byte[] bArr) {
        this.$this_withIndex = bArr;
        super(0);
    }

    @NotNull
    public final ByteIterator invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
