package kotlin.sequences;

import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$minus$4$iterator$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ HashSet $other;

    SequencesKt___SequencesKt$minus$4$iterator$1(HashSet hashSet) {
        this.$other = hashSet;
        super(1);
    }

    public final boolean invoke(T t) {
        return this.$other.contains(t);
    }
}
