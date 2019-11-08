package kotlin.text;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        this.$delimitersList = list;
        this.$ignoreCase = z;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CharSequence) obj, ((Number) obj2).intValue());
    }

    @Nullable
    public final Pair<Integer, Integer> invoke(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Pair access$findAnyOf = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, this.$delimitersList, i, this.$ignoreCase, false);
        if (access$findAnyOf != null) {
            return TuplesKt.to(access$findAnyOf.getFirst(), Integer.valueOf(((String) access$findAnyOf.getSecond()).length()));
        }
        return null;
    }
}
