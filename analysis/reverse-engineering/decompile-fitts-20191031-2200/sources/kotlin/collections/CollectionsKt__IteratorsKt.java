package kotlin.collections;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    @NotNull
    public static final <T> Iterator<IndexedValue<T>> withIndex(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "receiver$0");
        return new IndexingIterator(it);
    }

    public static final <T> void forEach(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(it, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "operation");
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }
}
