package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6 implements Iterable<Float>, KMappedMarker {
    final /* synthetic */ float[] $this_asIterable$inlined;

    public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6(float[] fArr) {
        this.$this_asIterable$inlined = fArr;
    }

    @NotNull
    public Iterator<Float> iterator() {
        return ArrayIteratorsKt.iterator(this.$this_asIterable$inlined);
    }
}
