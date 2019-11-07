package kotlin.text;

import java.util.Iterator;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class StringsKt___StringsKt$asSequence$$inlined$Sequence$1 implements Sequence<Character> {
    final /* synthetic */ CharSequence $this_asSequence$inlined;

    public StringsKt___StringsKt$asSequence$$inlined$Sequence$1(CharSequence charSequence) {
        this.$this_asSequence$inlined = charSequence;
    }

    @NotNull
    public Iterator<Character> iterator() {
        return StringsKt__StringsKt.iterator(this.$this_asSequence$inlined);
    }
}
