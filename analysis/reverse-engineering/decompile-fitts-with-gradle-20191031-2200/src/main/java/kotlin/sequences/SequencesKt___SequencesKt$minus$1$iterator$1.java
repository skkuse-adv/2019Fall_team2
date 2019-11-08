package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ Ref$BooleanRef $removed;
    final /* synthetic */ SequencesKt___SequencesKt$minus$1 this$0;

    SequencesKt___SequencesKt$minus$1$iterator$1(SequencesKt___SequencesKt$minus$1 sequencesKt___SequencesKt$minus$1, Ref$BooleanRef ref$BooleanRef) {
        this.this$0 = sequencesKt___SequencesKt$minus$1;
        this.$removed = ref$BooleanRef;
        super(1);
    }

    public final boolean invoke(T t) {
        if (this.$removed.element || !Intrinsics.areEqual((Object) t, this.this$0.$element)) {
            return true;
        }
        this.$removed.element = true;
        return false;
    }
}
