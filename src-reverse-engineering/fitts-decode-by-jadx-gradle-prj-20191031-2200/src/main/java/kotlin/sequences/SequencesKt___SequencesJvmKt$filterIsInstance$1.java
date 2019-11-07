package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class $klass;

    SequencesKt___SequencesJvmKt$filterIsInstance$1(Class cls) {
        this.$klass = cls;
        super(1);
    }

    public final boolean invoke(@Nullable Object obj) {
        return this.$klass.isInstance(obj);
    }
}
