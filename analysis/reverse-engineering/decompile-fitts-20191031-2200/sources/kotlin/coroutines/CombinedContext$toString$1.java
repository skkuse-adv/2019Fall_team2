package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class CombinedContext$toString$1 extends Lambda implements Function2<String, Element, String> {
    public static final CombinedContext$toString$1 INSTANCE = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    @NotNull
    public final String invoke(@NotNull String str, @NotNull Element element) {
        Intrinsics.checkParameterIsNotNull(str, "acc");
        Intrinsics.checkParameterIsNotNull(element, "element");
        if (str.length() == 0) {
            return element.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(", ");
        sb.append(element);
        return sb.toString();
    }
}
