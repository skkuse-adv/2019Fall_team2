package kotlin.text;

import kotlin.collections.CharIterator;

public final class StringsKt__StringsKt$iterator$1 extends CharIterator {
    final /* synthetic */ CharSequence $this_iterator;
    private int index;

    StringsKt__StringsKt$iterator$1(CharSequence charSequence) {
        this.$this_iterator = charSequence;
    }

    public char nextChar() {
        CharSequence charSequence = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        return charSequence.charAt(i);
    }

    public boolean hasNext() {
        return this.index < this.$this_iterator.length();
    }
}
