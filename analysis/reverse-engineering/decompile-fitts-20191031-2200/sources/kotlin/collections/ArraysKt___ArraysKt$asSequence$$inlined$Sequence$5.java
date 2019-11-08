package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5 implements Sequence<Long> {
    final /* synthetic */ long[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5(long[] jArr) {
        this.$this_asSequence$inlined = jArr;
    }

    @NotNull
    public Iterator<Long> iterator() {
        return ArrayIteratorsKt.iterator(this.$this_asSequence$inlined);
    }
}
