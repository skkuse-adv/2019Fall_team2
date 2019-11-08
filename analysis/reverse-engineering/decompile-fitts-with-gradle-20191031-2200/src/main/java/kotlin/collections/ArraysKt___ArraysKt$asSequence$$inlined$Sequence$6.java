package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6 implements Sequence<Float> {
    final /* synthetic */ float[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6(float[] fArr) {
        this.$this_asSequence$inlined = fArr;
    }

    @NotNull
    public Iterator<Float> iterator() {
        return ArrayIteratorsKt.iterator(this.$this_asSequence$inlined);
    }
}
