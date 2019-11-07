package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> boolean contains(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return indexOf(iterable, t) >= 0;
    }

    public static final <T> T elementAt(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return ((List) iterable).get(i);
        }
        return elementAtOrElse(iterable, i, new CollectionsKt___CollectionsKt$elementAt$1(i));
    }

    public static final <T> T elementAtOrElse(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(list)) ? function1.invoke(Integer.valueOf(i)) : list.get(i);
        } else if (i < 0) {
            return function1.invoke(Integer.valueOf(i));
        } else {
            int i2 = 0;
            for (T next : iterable) {
                int i3 = i2 + 1;
                if (i == i2) {
                    return next;
                }
                i2 = i3;
            }
            return function1.invoke(Integer.valueOf(i));
        }
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return getOrNull((List) iterable, i);
        }
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T next : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return next;
            }
            i2 = i3;
        }
        return null;
    }

    public static final <T> T first(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return first((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T first(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T first(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                return next;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    @Nullable
    public static <T> T firstOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public static <T> T getOrNull(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(list)) {
            return null;
        }
        return list.get(i);
    }

    public static final <T> int indexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (Object next : iterable) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((Object) t, next)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> int indexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        return list.indexOf(t);
    }

    public static final <T> int indexOfFirst(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (Object next : iterable) {
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (Object invoke : list) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = -1;
        int i2 = 0;
        for (Object next : iterable) {
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public static final <T> int indexOfLast(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (((Boolean) function1.invoke(listIterator.previous())).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static final <T> T last(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return last((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T last(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T last(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                t = next;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T> T last(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (((Boolean) function1.invoke(previous)).booleanValue()) {
                return previous;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int i = -1;
        int i2 = 0;
        for (Object next : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((Object) t, next)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public static final <T> int lastIndexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        return list.lastIndexOf(t);
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        T t = null;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                t = list.get(list.size() - 1);
            }
            return t;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                t = next;
            }
        }
        return t;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (((Boolean) function1.invoke(previous)).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    public static final <T> T random(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!collection.isEmpty()) {
            return elementAt(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T single(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof List) {
            return single((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T single(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> T single(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                if (!z) {
                    t = next;
                    z = true;
                } else {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        T t = null;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                t = list.get(0);
            }
            return t;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @Nullable
    public static <T> T singleOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        boolean z = false;
        T t = null;
        for (T next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = next;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    @NotNull
    public static final <T> List<T> drop(@NotNull Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return toList(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                if (size == 1) {
                    return CollectionsKt__CollectionsJVMKt.listOf(last(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object next : iterable) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    arrayList.add(next);
                }
                i2 = i3;
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
    }

    @NotNull
    public static final <T> List<T> dropLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (i >= 0) {
            return take(list, RangesKt___RangesKt.coerceAtLeast(list.size() - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (!list.isEmpty()) {
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!((Boolean) function1.invoke(listIterator.previous())).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Object next : iterable) {
            if (z) {
                arrayList.add(next);
            } else if (!((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (((Boolean) function2.invoke(Integer.valueOf(i), next)).booleanValue()) {
                arrayList.add(next);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNotNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (Object next : iterable) {
            if (next != null) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object next : iterable) {
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return toList(list.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(list.get(intValue.intValue()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> take(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return toList(iterable);
                }
                if (i == 1) {
                    return CollectionsKt__CollectionsJVMKt.listOf(first(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            for (Object next : iterable) {
                int i3 = i2 + 1;
                if (i2 == i) {
                    break;
                }
                arrayList.add(next);
                i2 = i3;
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int size = list.size();
            if (i >= size) {
                return toList(list);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(last(list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i2 = size - i; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                ListIterator listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!((Boolean) function1.invoke(listIterator.previous())).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
                break;
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        CollectionsKt__MutableCollectionsJVMKt.sortWith(list, ComparisonsKt__ComparisonsKt.reverseOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            if (array == null) {
                throw new TypeCastException(str);
            } else if (array != null) {
                Comparable[] comparableArr = (Comparable[]) array;
                if (comparableArr != null) {
                    ArraysKt___ArraysJvmKt.sort((T[]) comparableArr);
                    return ArraysKt___ArraysJvmKt.asList((T[]) comparableArr);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            } else {
                throw new TypeCastException(str);
            }
        } else {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            return mutableList;
        }
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return sortedWith(iterable, ComparisonsKt__ComparisonsKt.reverseOrder());
    }

    @NotNull
    public static final <T> List<T> sortedWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            if (array == null) {
                throw new TypeCastException(str);
            } else if (array != null) {
                ArraysKt___ArraysJvmKt.sortWith(array, comparator);
                return ArraysKt___ArraysJvmKt.asList((T[]) array);
            } else {
                throw new TypeCastException(str);
            }
        } else {
            List<T> mutableList = toMutableList(iterable);
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, comparator);
            return mutableList;
        }
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Collection<Boolean> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        boolean[] zArr = new boolean[collection.size()];
        int i = 0;
        for (Boolean booleanValue : collection) {
            int i2 = i + 1;
            zArr[i] = booleanValue.booleanValue();
            i = i2;
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Collection<Byte> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        byte[] bArr = new byte[collection.size()];
        int i = 0;
        for (Number byteValue : collection) {
            int i2 = i + 1;
            bArr[i] = byteValue.byteValue();
            i = i2;
        }
        return bArr;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Collection<Character> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return cArr;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Collection<Double> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        double[] dArr = new double[collection.size()];
        int i = 0;
        for (Number doubleValue : collection) {
            int i2 = i + 1;
            dArr[i] = doubleValue.doubleValue();
            i = i2;
        }
        return dArr;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Collection<Float> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        float[] fArr = new float[collection.size()];
        int i = 0;
        for (Number floatValue : collection) {
            int i2 = i + 1;
            fArr[i] = floatValue.floatValue();
            i = i2;
        }
        return fArr;
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            iArr[i] = intValue.intValue();
            i = i2;
        }
        return iArr;
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Collection<Long> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (Number longValue : collection) {
            int i2 = i + 1;
            jArr[i] = longValue.longValue();
            i = i2;
        }
        return jArr;
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Collection<Short> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        short[] sArr = new short[collection.size()];
        int i = 0;
        for (Number shortValue : collection) {
            int i2 = i + 1;
            sArr[i] = shortValue.shortValue();
            i = i2;
        }
        return sArr;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object invoke : iterable) {
            Pair pair = (Pair) function1.invoke(invoke);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(function1.invoke(next), next);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(function1.invoke(next), function12.invoke(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (Object next : iterable) {
            m.put(function1.invoke(next), next);
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (Object next : iterable) {
            m.put(function1.invoke(next), function12.invoke(next));
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : iterable) {
            Pair pair = (Pair) function1.invoke(invoke);
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Iterable<? extends K> iterable, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(next, function1.invoke(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Iterable<? extends K> iterable, @NotNull M m, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "valueSelector");
        for (Object next : iterable) {
            m.put(next, function1.invoke(next));
        }
        return m;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (Object add : iterable) {
            c.add(add);
        }
        return c;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return (HashSet) toCollection(iterable, new HashSet(MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 12))));
    }

    @NotNull
    public static <T> List<T> toList(@NotNull Iterable<? extends T> iterable) {
        List<T> list;
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else if (size != 1) {
            list = toMutableList(collection);
        } else {
            list = CollectionsKt__CollectionsJVMKt.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    @NotNull
    public static <T> List<T> toMutableList(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        return new ArrayList(collection);
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull Iterable<? extends T> iterable) {
        Set<T> set;
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (!(iterable instanceof Collection)) {
            return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            set = SetsKt__SetsKt.emptySet();
        } else if (size != 1) {
            set = (Set) toCollection(iterable, new LinkedHashSet(MapsKt__MapsKt.mapCapacity(collection.size())));
        } else {
            set = SetsKt__SetsJVMKt.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return set;
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Object invoke : iterable) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : iterable) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : iterable) {
            Object invoke = function1.invoke(next);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : iterable) {
            Object invoke = function1.invoke(next);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (Object next : iterable) {
            Object invoke = function1.invoke(next);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(next);
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (Object next : iterable) {
            Object invoke = function1.invoke(next);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(next));
        }
        return m;
    }

    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        return new CollectionsKt___CollectionsKt$groupingBy$1(iterable, function1);
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object invoke : iterable) {
            arrayList.add(function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            arrayList.add(function2.invoke(Integer.valueOf(i), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i), next);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            c.add(function2.invoke(Integer.valueOf(i), next));
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Object invoke : iterable) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : iterable) {
            c.add(function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return new IndexingIterable(new CollectionsKt___CollectionsKt$withIndex$1(iterable));
    }

    @NotNull
    public static <T> List<T> distinct(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return toList(toMutableSet(iterable));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (hashSet.add(function1.invoke(next))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable2);
        return mutableSet;
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable2);
        return mutableSet;
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) toCollection(iterable, new LinkedHashSet());
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(iterable);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T> boolean all(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object invoke : iterable) {
            if (!((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return !((Collection) iterable).isEmpty();
        }
        return iterable.iterator().hasNext();
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Object invoke : iterable) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i = 0;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        int i = 0;
        for (Object invoke : iterable) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                i++;
                if (i >= 0) {
                    continue;
                } else if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                } else {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i;
    }

    public static final <T, R> R fold(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (Object invoke : iterable) {
            r = function2.invoke(r, invoke);
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            r = function3.invoke(Integer.valueOf(i), r, next);
            i = i2;
        }
        return r;
    }

    public static final <T, R> R foldRight(@NotNull List<? extends T> list, R r, @NotNull Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        if (!list.isEmpty()) {
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = function2.invoke(listIterator.previous(), r);
            }
        }
        return r;
    }

    public static final <T, R> R foldRightIndexed(@NotNull List<? extends T> list, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        if (!list.isEmpty()) {
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = function3.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r);
            }
        }
        return r;
    }

    public static final <T> void forEach(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (Object invoke : iterable) {
            function1.invoke(invoke);
        }
    }

    public static final <T> void forEachIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            function2.invoke(Integer.valueOf(i), next);
            i = i2;
        }
    }

    @Nullable
    /* renamed from: max reason: collision with other method in class */
    public static final Double m118max(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = ((Number) it.next()).doubleValue();
        if (Double.isNaN(doubleValue)) {
            return Double.valueOf(doubleValue);
        }
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            if (Double.isNaN(doubleValue2)) {
                return Double.valueOf(doubleValue2);
            }
            if (doubleValue < doubleValue2) {
                doubleValue = doubleValue2;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    /* renamed from: max reason: collision with other method in class */
    public static final Float m119max(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) it.next()).floatValue();
        if (Float.isNaN(floatValue)) {
            return Float.valueOf(floatValue);
        }
        while (it.hasNext()) {
            float floatValue2 = ((Number) it.next()).floatValue();
            if (Float.isNaN(floatValue2)) {
                return Float.valueOf(floatValue2);
            }
            if (floatValue < floatValue2) {
                floatValue = floatValue2;
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    public static final <T extends Comparable<? super T>> T max(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (Comparable) it.next();
        while (it.hasNext()) {
            T t2 = (Comparable) it.next();
            if (t.compareTo(t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        Comparable comparable = (Comparable) function1.invoke(next);
        while (it.hasNext()) {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) function1.invoke(next2);
            if (comparable.compareTo(comparable2) < 0) {
                next = next2;
                comparable = comparable2;
            }
        }
        return next;
    }

    @Nullable
    public static final <T> T maxWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @Nullable
    /* renamed from: min reason: collision with other method in class */
    public static final Double m120min(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = ((Number) it.next()).doubleValue();
        if (Double.isNaN(doubleValue)) {
            return Double.valueOf(doubleValue);
        }
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            if (Double.isNaN(doubleValue2)) {
                return Double.valueOf(doubleValue2);
            }
            if (doubleValue > doubleValue2) {
                doubleValue = doubleValue2;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    /* renamed from: min reason: collision with other method in class */
    public static final Float m121min(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) it.next()).floatValue();
        if (Float.isNaN(floatValue)) {
            return Float.valueOf(floatValue);
        }
        while (it.hasNext()) {
            float floatValue2 = ((Number) it.next()).floatValue();
            if (Float.isNaN(floatValue2)) {
                return Float.valueOf(floatValue2);
            }
            if (floatValue > floatValue2) {
                floatValue = floatValue2;
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    public static <T extends Comparable<? super T>> T min(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (Comparable) it.next();
        while (it.hasNext()) {
            T t2 = (Comparable) it.next();
            if (t.compareTo(t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        Comparable comparable = (Comparable) function1.invoke(next);
        while (it.hasNext()) {
            T next2 = it.next();
            Comparable comparable2 = (Comparable) function1.invoke(next2);
            if (comparable.compareTo(comparable2) > 0) {
                next = next2;
                comparable = comparable2;
            }
        }
        return next;
    }

    @Nullable
    public static final <T> T minWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object invoke : iterable) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=C, code=C<java.lang.Object>, for r2v0, types: [C, C<java.lang.Object>, java.lang.Object, java.lang.Iterable] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, C extends java.lang.Iterable<? extends T>> C onEach(@org.jetbrains.annotations.NotNull C<java.lang.Object> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.util.Iterator r0 = r2.iterator()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r0.next()
            r3.invoke(r1)
            goto L_0x000e
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.onEach(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Iterable");
    }

    public static final <S, T extends S> S reduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = function2.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            int i = 1;
            while (it.hasNext()) {
                int i2 = i + 1;
                if (i < 0) {
                    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                next = function3.invoke(Integer.valueOf(i), next, it.next());
                i = i2;
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceRight(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        ListIterator listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = function2.invoke(listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        ListIterator listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = function3.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <T> int sumBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (Object invoke : iterable) {
            i += ((Number) function1.invoke(invoke)).intValue();
        }
        return i;
    }

    public static final <T> double sumByDouble(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Object invoke : iterable) {
            d += ((Number) function1.invoke(invoke)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <T> Iterable<T> requireNoNulls(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        for (Object obj : iterable) {
            if (obj == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("null element found in ");
                sb.append(iterable);
                sb.append('.');
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return iterable;
    }

    @NotNull
    public static final <T> List<T> requireNoNulls(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        for (Object obj : list) {
            if (obj == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("null element found in ");
                sb.append(list);
                sb.append('.');
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return list;
    }

    @NotNull
    public static final <T> List<List<T>> chunked(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return windowed(iterable, i, i, true);
    }

    @NotNull
    public static final <T, R> List<R> chunked(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return windowed(iterable, i, i, true, function1);
    }

    @NotNull
    public static <T> List<T> minus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        boolean z = false;
        for (Object next : iterable) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(next, (Object) t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            return toList(iterable);
        }
        HashSet hashSet = ArraysKt___ArraysKt.toHashSet(tArr);
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!hashSet.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, MessengerShareContentUtility.ELEMENTS);
        Collection convertToSetForSetOperationWith = CollectionsKt__IterablesKt.convertToSetForSetOperationWith(iterable2, iterable);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!convertToSetForSetOperationWith.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        if (hashSet.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!hashSet.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, t);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> plus(@NotNull Collection<? extends T> collection, T t) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, tArr);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, tArr);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, tArr);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, iterable2);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList2, iterable);
        return arrayList2;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, sequence);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(collection, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, sequence);
        return arrayList;
    }

    @NotNull
    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z);
    }

    @NotNull
    public static final <T> List<List<T>> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, false);
            while (windowedIterator.hasNext()) {
                arrayList.add((List) windowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList(((size + i2) - 1) / i2);
        int i3 = 0;
        while (i3 < size) {
            int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, size - i3);
            if (coerceAtMost < i && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(coerceAtMost);
            for (int i4 = 0; i4 < coerceAtMost; i4++) {
                arrayList3.add(list.get(i4 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    @NotNull
    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z, function1);
    }

    @NotNull
    public static final <T, R> List<R> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, true);
            while (windowedIterator.hasNext()) {
                arrayList.add(function1.invoke((List) windowedIterator.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList(((size + i2) - 1) / i2);
        MovingSubList movingSubList = new MovingSubList(list);
        int i3 = 0;
        while (i3 < size) {
            movingSubList.move(i3, RangesKt___RangesKt.coerceAtMost(i3 + i, size));
            if (!z && movingSubList.size() < i) {
                break;
            }
            arrayList2.add(function1.invoke(movingSubList));
            i3 += i2;
        }
        return arrayList2;
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] rArr, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(next, rArr[i]));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> iterable2, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(function2.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> zipWithNext(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            arrayList.add(function2.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(iterable, appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Iterable<? extends T> iterable, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object next : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt__StringBuilderKt.appendElement(a, next, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static <T> Sequence<T> asSequence(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(iterable);
    }

    public static final double averageOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number byteValue : iterable) {
            double byteValue2 = (double) byteValue.byteValue();
            Double.isNaN(byteValue2);
            d += byteValue2;
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number shortValue : iterable) {
            double shortValue2 = (double) shortValue.shortValue();
            Double.isNaN(shortValue2);
            d += shortValue2;
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number intValue : iterable) {
            double intValue2 = (double) intValue.intValue();
            Double.isNaN(intValue2);
            d += intValue2;
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number longValue : iterable) {
            double longValue2 = (double) longValue.longValue();
            Double.isNaN(longValue2);
            d += longValue2;
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number floatValue : iterable) {
            double floatValue2 = (double) floatValue.floatValue();
            Double.isNaN(floatValue2);
            d += floatValue2;
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number doubleValue : iterable) {
            d += doubleValue.doubleValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final int sumOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        int i = 0;
        for (Number byteValue : iterable) {
            i += byteValue.byteValue();
        }
        return i;
    }

    public static final int sumOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        int i = 0;
        for (Number shortValue : iterable) {
            i += shortValue.shortValue();
        }
        return i;
    }

    public static final int sumOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        int i = 0;
        for (Number intValue : iterable) {
            i += intValue.intValue();
        }
        return i;
    }

    public static final long sumOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        long j = 0;
        for (Number longValue : iterable) {
            j += longValue.longValue();
        }
        return j;
    }

    public static final float sumOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        float f = 0.0f;
        for (Number floatValue : iterable) {
            f += floatValue.floatValue();
        }
        return f;
    }

    public static final double sumOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Number doubleValue : iterable) {
            d += doubleValue.doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (((Boolean) function2.invoke(Integer.valueOf(i), next)).booleanValue()) {
                c.add(next);
            }
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i), next);
            if (invoke != null) {
                c.add(invoke);
            }
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : iterable) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                c.add(invoke2);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(next, rArr[i]));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> iterable2) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable2, FacebookRequestErrorClassification.KEY_OTHER);
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<Pair<T, T>> zipWithNext(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            arrayList.add(TuplesKt.to(next, next2));
            next = next2;
        }
        return arrayList;
    }
}
