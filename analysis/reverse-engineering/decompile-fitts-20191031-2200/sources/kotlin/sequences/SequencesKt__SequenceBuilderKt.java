package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class SequencesKt__SequenceBuilderKt {
    public static /* synthetic */ void SequenceBuilder$annotations() {
    }

    @NotNull
    public static <T> Sequence<T> sequence(@NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(function2);
    }

    @NotNull
    public static <T> Iterator<T> iterator(@NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.setNextStep(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }
}
