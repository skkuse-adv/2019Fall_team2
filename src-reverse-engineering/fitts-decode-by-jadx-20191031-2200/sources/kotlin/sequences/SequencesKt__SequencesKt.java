package kotlin.sequences;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "receiver$0");
        return constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it));
    }

    @NotNull
    public static final <T> Sequence<T> sequenceOf(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? emptySequence() : ArraysKt___ArraysKt.asSequence(tArr);
    }

    @NotNull
    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull Sequence<? extends T> sequence, @NotNull Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(sequence, function0, null));
    }

    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return flatten$SequencesKt__SequencesKt(sequence, SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }

    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return flatten$SequencesKt__SequencesKt(sequence, SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(@NotNull Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1);
        }
        return new FlatteningSequence(sequence, SequencesKt__SequencesKt$flatten$3.INSTANCE, function1);
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> Sequence<T> constrainOnce(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "nextFunction");
        return constrainOnce(new GeneratorSequence(function0, new SequencesKt__SequencesKt$generateSequence$1(function0)));
    }

    @NotNull
    public static final <T> Sequence<T> generateSequence(@Nullable T t, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "nextFunction");
        if (t == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(new SequencesKt__SequencesKt$generateSequence$2(t), function1);
    }

    @NotNull
    public static <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "seedFunction");
        Intrinsics.checkParameterIsNotNull(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }
}
