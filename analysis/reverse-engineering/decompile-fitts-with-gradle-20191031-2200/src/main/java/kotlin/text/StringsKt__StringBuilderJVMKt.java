package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @NotNull
    public static final StringBuilder clear(@NotNull StringBuilder sb) {
        Intrinsics.checkParameterIsNotNull(sb, "receiver$0");
        sb.setLength(0);
        return sb;
    }

    @NotNull
    public static Appendable appendln(@NotNull Appendable appendable) {
        Intrinsics.checkParameterIsNotNull(appendable, "receiver$0");
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @NotNull
    public static final StringBuilder appendln(@NotNull StringBuilder sb) {
        Intrinsics.checkParameterIsNotNull(sb, "receiver$0");
        sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }
}
