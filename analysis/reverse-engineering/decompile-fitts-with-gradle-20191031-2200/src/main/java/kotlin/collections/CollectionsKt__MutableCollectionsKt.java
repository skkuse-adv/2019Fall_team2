package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        boolean z = false;
        for (Object add : sequence) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return collection.addAll(ArraysKt___ArraysJvmKt.asList(tArr));
    }

    public static final <T> boolean removeAll(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(iterable, function1, true);
    }

    public static <T> boolean retainAll(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(iterable, function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@NotNull Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean removeAll(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(list, function1, true);
    }

    public static final <T> boolean retainAll(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt(list, function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@NotNull List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i;
        if (list instanceof RandomAccess) {
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (lastIndex >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    Object obj = list.get(i2);
                    if (((Boolean) function1.invoke(obj)).booleanValue() != z) {
                        if (i != i2) {
                            list.set(i, obj);
                        }
                        i++;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            } else {
                i = 0;
            }
            if (i >= list.size()) {
                return false;
            }
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (lastIndex2 >= i) {
                while (true) {
                    list.remove(lastIndex2);
                    if (lastIndex2 == i) {
                        break;
                    }
                    lastIndex2--;
                }
            }
            return true;
        } else if (list != null) {
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        return TypeIntrinsics.asMutableCollection(collection).removeAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        return (hashSet.isEmpty() ^ true) && collection.removeAll(hashSet);
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return ((tArr.length == 0) ^ true) && collection.removeAll(ArraysKt___ArraysKt.toHashSet(tArr));
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        return TypeIntrinsics.asMutableCollection(collection).retainAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        if (!(tArr.length == 0)) {
            return collection.retainAll(ArraysKt___ArraysKt.toHashSet(tArr));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        if (!hashSet.isEmpty()) {
            return collection.retainAll(hashSet);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(@NotNull Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> void shuffle(@NotNull List<T> list, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            Object obj = list.get(lastIndex);
            list.set(lastIndex, list.get(nextInt));
            list.set(nextInt, obj);
        }
    }

    @NotNull
    public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        shuffle(mutableList, random);
        return mutableList;
    }
}
