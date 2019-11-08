package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    /* access modifiers changed from: private */
    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(@NotNull List<?> list, int i) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return CollectionsKt__CollectionsKt.getLastIndex(list) - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Element index ");
        sb.append(i);
        sb.append(" must be in range [");
        sb.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* access modifiers changed from: private */
    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(@NotNull List<?> list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Position index ");
        sb.append(i);
        sb.append(" must be in range [");
        sb.append(new IntRange(0, list.size()));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @NotNull
    public static final <T> List<T> asReversed(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        return new ReversedListReadOnly(list);
    }

    @NotNull
    public static final <T> List<T> asReversedMutable(@NotNull List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        return new ReversedList(list);
    }
}
