package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1 implements Sequence<T> {
    final /* synthetic */ Object[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1(Object[] objArr) {
        this.$this_asSequence$inlined = objArr;
    }

    @NotNull
    public Iterator<T> iterator() {
        return ArrayIteratorKt.iterator(this.$this_asSequence$inlined);
    }
}
