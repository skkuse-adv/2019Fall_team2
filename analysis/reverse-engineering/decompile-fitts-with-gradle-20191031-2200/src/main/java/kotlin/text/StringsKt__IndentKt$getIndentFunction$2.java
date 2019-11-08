package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements Function1<String, String> {
    final /* synthetic */ String $indent;

    StringsKt__IndentKt$getIndentFunction$2(String str) {
        this.$indent = str;
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "line");
        StringBuilder sb = new StringBuilder();
        sb.append(this.$indent);
        sb.append(str);
        return sb.toString();
    }
}
