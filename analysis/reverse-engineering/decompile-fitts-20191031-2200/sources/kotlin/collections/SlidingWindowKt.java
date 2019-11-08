package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int i, int i2) {
        String str;
        if (!(i > 0 && i2 > 0)) {
            String str2 = " must be greater than zero.";
            if (i != i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Both size ");
                sb.append(i);
                sb.append(" and step ");
                sb.append(i2);
                sb.append(str2);
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("size ");
                sb2.append(i);
                sb2.append(str2);
                str = sb2.toString();
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @NotNull
    public static final <T> Sequence<List<T>> windowedSequence(@NotNull Sequence<? extends T> sequence, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        checkWindowSizeStep(i, i2);
        SlidingWindowKt$windowedSequence$$inlined$Sequence$1 slidingWindowKt$windowedSequence$$inlined$Sequence$1 = new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(sequence, i, i2, z, z2);
        return slidingWindowKt$windowedSequence$$inlined$Sequence$1;
    }

    @NotNull
    public static final <T> Iterator<List<T>> windowedIterator(@NotNull Iterator<? extends T> it, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(it, "iterator");
        if (!it.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(i2, i, it, z2, z, null);
        return SequencesKt__SequenceBuilderKt.iterator(slidingWindowKt$windowedIterator$1);
    }
}
