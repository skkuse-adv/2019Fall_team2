package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7 implements Sequence<Double> {
    final /* synthetic */ double[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7(double[] dArr) {
        this.$this_asSequence$inlined = dArr;
    }

    @NotNull
    public Iterator<Double> iterator() {
        return ArrayIteratorsKt.iterator(this.$this_asSequence$inlined);
    }
}
