package kotlin.text;

import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class DelimitedRangesSequence implements Sequence<IntRange> {
    /* access modifiers changed from: private */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    /* access modifiers changed from: private */
    public final CharSequence input;
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final int startIndex;

    public DelimitedRangesSequence(@NotNull CharSequence charSequence, int i, int i2, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Intrinsics.checkParameterIsNotNull(function2, "getNextMatch");
        this.input = charSequence;
        this.startIndex = i;
        this.limit = i2;
        this.getNextMatch = function2;
    }

    @NotNull
    public Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
