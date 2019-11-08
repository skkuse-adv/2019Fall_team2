package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

class SetsKt___SetsKt extends SetsKt__SetsKt {
    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size()));
        boolean z = false;
        for (Object next : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(next, (Object) t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) linkedHashSet, tArr);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        Collection convertToSetForSetOperationWith = CollectionsKt__IterablesKt.convertToSetForSetOperationWith(iterable, set);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return CollectionsKt___CollectionsKt.toSet(set);
        }
        if (convertToSetForSetOperationWith instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object next : set) {
                if (!convertToSetForSetOperationWith.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(convertToSetForSetOperationWith);
        return linkedHashSet2;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) linkedHashSet, sequence);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) linkedHashSet, tArr);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int i;
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        Integer collectionSizeOrNull = CollectionsKt__IterablesKt.collectionSizeOrNull(iterable);
        if (collectionSizeOrNull != null) {
            i = set.size() + collectionSizeOrNull.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(i));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(set, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) linkedHashSet, sequence);
        return linkedHashSet;
    }
}
