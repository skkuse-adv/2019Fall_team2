package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9 implements Sequence<Character> {
    final /* synthetic */ char[] $this_asSequence$inlined;

    public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9(char[] cArr) {
        this.$this_asSequence$inlined = cArr;
    }

    @NotNull
    public Iterator<Character> iterator() {
        return ArrayIteratorsKt.iterator(this.$this_asSequence$inlined);
    }
}
