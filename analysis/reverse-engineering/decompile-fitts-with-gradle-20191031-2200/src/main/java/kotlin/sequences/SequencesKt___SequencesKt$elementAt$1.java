package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SequencesKt___SequencesKt$elementAt$1 extends Lambda implements Function1 {
    final /* synthetic */ int $index;

    SequencesKt___SequencesKt$elementAt$1(int i) {
        this.$index = i;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final Void invoke(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sequence doesn't contain element at index ");
        sb.append(this.$index);
        sb.append('.');
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
