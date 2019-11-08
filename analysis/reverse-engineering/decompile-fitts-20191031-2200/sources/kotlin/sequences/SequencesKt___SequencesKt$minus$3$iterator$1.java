package kotlin.sequences;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$minus$3$iterator$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ Collection $other;

    SequencesKt___SequencesKt$minus$3$iterator$1(Collection collection) {
        this.$other = collection;
        super(1);
    }

    public final boolean invoke(T t) {
        return this.$other.contains(t);
    }
}
