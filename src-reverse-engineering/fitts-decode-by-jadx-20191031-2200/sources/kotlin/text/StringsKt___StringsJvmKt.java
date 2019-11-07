package kotlin.text;

import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return (SortedSet) StringsKt___StringsKt.toCollection(charSequence, new TreeSet());
    }
}
