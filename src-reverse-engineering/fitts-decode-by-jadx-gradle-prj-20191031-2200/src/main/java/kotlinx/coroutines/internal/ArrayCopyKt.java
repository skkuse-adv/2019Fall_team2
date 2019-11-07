package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ArrayCopyKt {
    public static final <E> void arraycopy(@NotNull E[] eArr, int i, @NotNull E[] eArr2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(eArr, "source");
        Intrinsics.checkParameterIsNotNull(eArr2, "destination");
        System.arraycopy(eArr, i, eArr2, i2, i3);
    }
}
