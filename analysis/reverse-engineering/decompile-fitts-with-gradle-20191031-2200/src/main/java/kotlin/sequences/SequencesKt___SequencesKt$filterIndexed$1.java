package kotlin.sequences;

import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements Function1<IndexedValue<? extends T>, Boolean> {
    final /* synthetic */ Function2 $predicate;

    SequencesKt___SequencesKt$filterIndexed$1(Function2 function2) {
        this.$predicate = function2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((IndexedValue) obj));
    }

    public final boolean invoke(@NotNull IndexedValue<? extends T> indexedValue) {
        Intrinsics.checkParameterIsNotNull(indexedValue, "it");
        return ((Boolean) this.$predicate.invoke(Integer.valueOf(indexedValue.getIndex()), indexedValue.getValue())).booleanValue();
    }
}
