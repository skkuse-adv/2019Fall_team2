package kotlin.text;

import java.util.Iterator;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class StringsKt___StringsKt$groupingBy$1 implements Grouping<Character, K> {
    final /* synthetic */ Function1 $keySelector;
    final /* synthetic */ CharSequence $this_groupingBy;

    public StringsKt___StringsKt$groupingBy$1(CharSequence charSequence, Function1 function1) {
        this.$this_groupingBy = charSequence;
        this.$keySelector = function1;
    }

    public /* bridge */ /* synthetic */ Object keyOf(Object obj) {
        return keyOf(((Character) obj).charValue());
    }

    @NotNull
    public Iterator<Character> sourceIterator() {
        return StringsKt__StringsKt.iterator(this.$this_groupingBy);
    }

    public K keyOf(char c) {
        return this.$keySelector.invoke(Character.valueOf(c));
    }
}
