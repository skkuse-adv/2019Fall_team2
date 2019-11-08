package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class CollectionsKt__CollectionsJVMKt {
    @NotNull
    public static <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkExpressionValueIsNotNull(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    @NotNull
    public static final <T> Object[] copyToArrayOfAny(@NotNull T[] tArr, boolean z) {
        Class<Object[]> cls = Object[].class;
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (z && Intrinsics.areEqual((Object) tArr.getClass(), (Object) cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
