package kotlin.sequences;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements Function0<T> {
    final /* synthetic */ Object $seed;

    SequencesKt__SequencesKt$generateSequence$2(Object obj) {
        this.$seed = obj;
        super(0);
    }

    @Nullable
    public final T invoke() {
        return this.$seed;
    }
}
