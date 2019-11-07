package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements Function1<IntRange, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        this.$this_splitToSequence = charSequence;
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(intRange, "it");
        return StringsKt__StringsKt.substring(this.$this_splitToSequence, intRange);
    }
}
