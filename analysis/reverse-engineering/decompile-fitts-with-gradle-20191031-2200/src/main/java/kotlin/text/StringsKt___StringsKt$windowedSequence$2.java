package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ Function1 $transform;

    StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, Function1 function1, int i) {
        this.$this_windowedSequence = charSequence;
        this.$transform = function1;
        this.$size = i;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final R invoke(int i) {
        Function1 function1 = this.$transform;
        CharSequence charSequence = this.$this_windowedSequence;
        return function1.invoke(charSequence.subSequence(i, RangesKt___RangesKt.coerceAtMost(this.$size + i, charSequence.length())));
    }
}
