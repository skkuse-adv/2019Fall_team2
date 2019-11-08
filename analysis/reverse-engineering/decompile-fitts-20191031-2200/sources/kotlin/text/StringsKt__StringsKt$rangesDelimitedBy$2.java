package kotlin.text;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] $delimiters;
    final /* synthetic */ boolean $ignoreCase;

    StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArr, boolean z) {
        this.$delimiters = cArr;
        this.$ignoreCase = z;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    @Nullable
    public final Pair<Integer, Integer> invoke(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        int indexOfAny = StringsKt__StringsKt.indexOfAny(charSequence, this.$delimiters, i, this.$ignoreCase);
        if (indexOfAny < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(indexOfAny), Integer.valueOf(1));
    }
}
