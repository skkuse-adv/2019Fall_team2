package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @NotNull
    public static final <T extends Appendable> T append(@NotNull T t, @NotNull CharSequence... charSequenceArr) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequenceArr, "value");
        for (CharSequence append : charSequenceArr) {
            t.append(append);
        }
        return t;
    }

    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb, @NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(sb, "receiver$0");
        Intrinsics.checkParameterIsNotNull(strArr, "value");
        for (String append : strArr) {
            sb.append(append);
        }
        return sb;
    }

    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb, @NotNull Object... objArr) {
        Intrinsics.checkParameterIsNotNull(sb, "receiver$0");
        Intrinsics.checkParameterIsNotNull(objArr, "value");
        for (Object append : objArr) {
            sb.append(append);
        }
        return sb;
    }

    public static <T> void appendElement(@NotNull Appendable appendable, T t, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(appendable, "receiver$0");
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
