package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class StringsKt___StringsKt$asIterable$$inlined$Iterable$1 implements Iterable<Character>, KMappedMarker {
    final /* synthetic */ CharSequence $this_asIterable$inlined;

    public StringsKt___StringsKt$asIterable$$inlined$Iterable$1(CharSequence charSequence) {
        this.$this_asIterable$inlined = charSequence;
    }

    @NotNull
    public Iterator<Character> iterator() {
        return StringsKt__StringsKt.iterator(this.$this_asIterable$inlined);
    }
}
