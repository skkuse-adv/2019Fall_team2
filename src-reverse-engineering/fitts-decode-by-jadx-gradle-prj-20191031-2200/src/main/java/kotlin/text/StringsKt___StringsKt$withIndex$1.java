package kotlin.text;

import kotlin.collections.CharIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class StringsKt___StringsKt$withIndex$1 extends Lambda implements Function0<CharIterator> {
    final /* synthetic */ CharSequence $this_withIndex;

    StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        this.$this_withIndex = charSequence;
        super(0);
    }

    @NotNull
    public final CharIterator invoke() {
        return StringsKt__StringsKt.iterator(this.$this_withIndex);
    }
}
