package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<? extends T>> {
    final /* synthetic */ boolean $partialWindows$inlined;
    final /* synthetic */ boolean $reuseBuffer$inlined;
    final /* synthetic */ int $size$inlined;
    final /* synthetic */ int $step$inlined;
    final /* synthetic */ Sequence $this_windowedSequence$inlined;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence sequence, int i, int i2, boolean z, boolean z2) {
        this.$this_windowedSequence$inlined = sequence;
        this.$size$inlined = i;
        this.$step$inlined = i2;
        this.$partialWindows$inlined = z;
        this.$reuseBuffer$inlined = z2;
    }

    @NotNull
    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), this.$size$inlined, this.$step$inlined, this.$partialWindows$inlined, this.$reuseBuffer$inlined);
    }
}
