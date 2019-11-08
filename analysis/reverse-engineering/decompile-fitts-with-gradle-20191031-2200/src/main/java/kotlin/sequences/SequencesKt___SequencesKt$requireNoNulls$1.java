package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements Function1<T, T> {
    final /* synthetic */ Sequence $this_requireNoNulls;

    SequencesKt___SequencesKt$requireNoNulls$1(Sequence sequence) {
        this.$this_requireNoNulls = sequence;
        super(1);
    }

    @NotNull
    public final T invoke(@Nullable T t) {
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("null element found in ");
        sb.append(this.$this_requireNoNulls);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }
}
