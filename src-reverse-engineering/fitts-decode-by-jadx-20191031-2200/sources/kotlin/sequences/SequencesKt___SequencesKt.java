package kotlin.sequences;

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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static final <T> boolean contains(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return indexOf(sequence, t) >= 0;
    }

    public static final <T> T elementAt(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return elementAtOrElse(sequence, i, new SequencesKt___SequencesKt$elementAt$1(i));
    }

    public static final <T> T elementAtOrElse(@NotNull Sequence<? extends T> sequence, int i, @NotNull Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "defaultValue");
        if (i < 0) {
            return function1.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T next : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return next;
            }
            i2 = i3;
        }
        return function1.invoke(Integer.valueOf(i));
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T next : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return next;
            }
            i2 = i3;
        }
        return null;
    }

    public static final <T> T first(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T first(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                return next;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                return next;
            }
        }
        return null;
    }

    public static final <T> int indexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        int i = 0;
        for (Object next : sequence) {
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

    public static final <T> int indexOfFirst(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (Object next : sequence) {
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

    public static final <T> int indexOfLast(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = -1;
        int i2 = 0;
        for (Object next : sequence) {
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

    public static final <T> T last(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T last(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                t = next;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        int i = -1;
        int i2 = 0;
        for (Object next : sequence) {
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

    @Nullable
    public static final <T> T lastOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T> T lastOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        for (T next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                t = next;
            }
        }
        return t;
    }

    public static final <T> T single(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T single(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                if (!z) {
                    t = next;
                    z = true;
                } else {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T> T singleOrNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        boolean z = false;
        T t = null;
        for (T next : sequence) {
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
    public static final <T> Sequence<T> drop(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).drop(i);
            }
            return new DropSequence(sequence, i);
        }
    }

    @NotNull
    public static final <T> Sequence<T> dropWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return new DropWhileSequence(sequence, function1);
    }

    @NotNull
    public static final <T> Sequence<T> filter(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return new FilteringSequence(sequence, true, function1);
    }

    @NotNull
    public static final <T> Sequence<T> filterIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        return new TransformingSequence(new FilteringSequence(new IndexingSequence(sequence), true, new SequencesKt___SequencesKt$filterIndexed$1(function2)), SequencesKt___SequencesKt$filterIndexed$2.INSTANCE);
    }

    @NotNull
    public static final <T> Sequence<T> filterNot(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return new FilteringSequence(sequence, false, function1);
    }

    @NotNull
    public static final <T> Sequence<T> filterNotNull(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Sequence<T> filterNot = filterNot(sequence, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        if (filterNot != null) {
            return filterNot;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (Object next : sequence) {
            if (next != null) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object next : sequence) {
            if (!((Boolean) function1.invoke(next)).booleanValue()) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T> Sequence<T> take(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).take(i);
            }
            return new TakeSequence(sequence, i);
        }
    }

    @NotNull
    public static final <T> Sequence<T> takeWhile(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        return new TakeWhileSequence(sequence, function1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sorted(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return new SequencesKt___SequencesKt$sorted$1(sequence);
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return sortedWith(sequence, ComparisonsKt__ComparisonsKt.reverseOrder());
    }

    @NotNull
    public static final <T> Sequence<T> sortedWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return new SequencesKt___SequencesKt$sortedWith$1(sequence, comparator);
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object invoke : sequence) {
            Pair pair = (Pair) function1.invoke(invoke);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
            linkedHashMap.put(function1.invoke(next), next);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
            linkedHashMap.put(function1.invoke(next), function12.invoke(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (Object next : sequence) {
            m.put(function1.invoke(next), next);
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (Object next : sequence) {
            m.put(function1.invoke(next), function12.invoke(next));
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Sequence<? extends T> sequence, @NotNull M m, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : sequence) {
            Pair pair = (Pair) function1.invoke(invoke);
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Sequence<? extends K> sequence, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
            linkedHashMap.put(next, function1.invoke(next));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Sequence<? extends K> sequence, @NotNull M m, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "valueSelector");
        for (Object next : sequence) {
            m.put(next, function1.invoke(next));
        }
        return m;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Sequence<? extends T> sequence, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (Object add : sequence) {
            c.add(add);
        }
        return c;
    }

    @NotNull
    public static <T> HashSet<T> toHashSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    @NotNull
    public static <T> List<T> toList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(sequence));
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return (List) toCollection(sequence, new ArrayList());
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return SetsKt__SetsKt.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    @NotNull
    public static final <T, R> Sequence<R> flatMap(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return new FlatteningSequence(sequence, function1, SequencesKt___SequencesKt$flatMap$1.INSTANCE);
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : sequence) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Sequence) function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
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
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : sequence) {
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
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (Object next : sequence) {
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
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Sequence<? extends T> sequence, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (Object next : sequence) {
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
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        return new SequencesKt___SequencesKt$groupingBy$1(sequence, function1);
    }

    @NotNull
    public static <T, R> Sequence<R> map(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return new TransformingSequence(sequence, function1);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return new TransformingIndexedSequence(sequence, function2);
    }

    @NotNull
    public static final <T, R> Sequence<R> mapIndexedNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return filterNotNull(new TransformingIndexedSequence(sequence, function2));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (Object next : sequence) {
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
    public static final <T, R> Sequence<R> mapNotNull(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return filterNotNull(new TransformingSequence(sequence, function1));
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : sequence) {
            c.add(function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <T> Sequence<IndexedValue<T>> withIndex(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return new IndexingSequence(sequence);
    }

    @NotNull
    public static final <T> Sequence<T> distinct(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return distinctBy(sequence, SequencesKt___SequencesKt$distinct$1.INSTANCE);
    }

    @NotNull
    public static final <T, K> Sequence<T> distinctBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return new DistinctSequence(sequence, function1);
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object add : sequence) {
            linkedHashSet.add(add);
        }
        return linkedHashSet;
    }

    public static final <T> boolean all(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object invoke : sequence) {
            if (!((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return sequence.iterator().hasNext();
    }

    public static final <T> boolean any(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object invoke : sequence) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> int count(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> int count(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (Object invoke : sequence) {
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

    public static final <T, R> R fold(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (Object invoke : sequence) {
            r = function2.invoke(r, invoke);
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull Sequence<? extends T> sequence, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (Object next : sequence) {
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

    public static final <T> void forEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (Object invoke : sequence) {
            function1.invoke(invoke);
        }
    }

    public static final <T> void forEachIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (Object next : sequence) {
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
    public static final Double m142max(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final Float m143max(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T extends Comparable<? super T>> T max(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator it = sequence.iterator();
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
    public static final <T> T maxWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Iterator it = sequence.iterator();
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
    public static final Double m144min(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final Float m145min(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T extends Comparable<? super T>> T min(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Iterator it = sequence.iterator();
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
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator it = sequence.iterator();
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
    public static final <T> T minWith(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Iterator it = sequence.iterator();
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

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return !sequence.iterator().hasNext();
    }

    public static final <T> boolean none(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Object invoke : sequence) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T> Sequence<T> onEach(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        return map(sequence, new SequencesKt___SequencesKt$onEach$1(function1));
    }

    public static final <S, T extends S> S reduce(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = function2.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Sequence<? extends T> sequence, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        Iterator it = sequence.iterator();
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
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <T> int sumBy(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (Object invoke : sequence) {
            i += ((Number) function1.invoke(invoke)).intValue();
        }
        return i;
    }

    public static final <T> double sumByDouble(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Object invoke : sequence) {
            d += ((Number) function1.invoke(invoke)).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <T> Sequence<T> requireNoNulls(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return map(sequence, new SequencesKt___SequencesKt$requireNoNulls$1(sequence));
    }

    @NotNull
    public static final <T> Sequence<List<T>> chunked(@NotNull Sequence<? extends T> sequence, int i) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return windowed(sequence, i, i, true);
    }

    @NotNull
    public static final <T, R> Sequence<R> chunked(@NotNull Sequence<? extends T> sequence, int i, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return windowed(sequence, i, i, true, function1);
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return new SequencesKt___SequencesKt$minus$1(sequence, t);
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            return sequence;
        }
        return new SequencesKt___SequencesKt$minus$2(sequence, tArr);
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        return new SequencesKt___SequencesKt$minus$3(sequence, iterable);
    }

    @NotNull
    public static final <T> Sequence<T> minus(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends T> sequence2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence2, MessengerShareContentUtility.ELEMENTS);
        return new SequencesKt___SequencesKt$minus$4(sequence, sequence2);
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : sequence) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, T t) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, SequencesKt__SequencesKt.sequenceOf(t)));
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr, MessengerShareContentUtility.ELEMENTS);
        return plus(sequence, (Iterable<? extends T>) ArraysKt___ArraysJvmKt.asList(tArr));
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, MessengerShareContentUtility.ELEMENTS);
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, CollectionsKt___CollectionsKt.asSequence(iterable)));
    }

    @NotNull
    public static final <T> Sequence<T> plus(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends T> sequence2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence2, MessengerShareContentUtility.ELEMENTS);
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf(sequence, sequence2));
    }

    @NotNull
    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i, i2, z);
    }

    @NotNull
    public static final <T> Sequence<List<T>> windowed(@NotNull Sequence<? extends T> sequence, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return SlidingWindowKt.windowedSequence(sequence, i, i2, z, false);
    }

    @NotNull
    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(sequence, i, i2, z, function1);
    }

    @NotNull
    public static final <T, R> Sequence<R> windowed(@NotNull Sequence<? extends T> sequence, int i, int i2, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        return map(SlidingWindowKt.windowedSequence(sequence, i, i2, z, true), function1);
    }

    @NotNull
    public static final <T, R> Sequence<Pair<T, R>> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> sequence2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence2, FacebookRequestErrorClassification.KEY_OTHER);
        return new MergingSequence(sequence, sequence2, SequencesKt___SequencesKt$zip$1.INSTANCE);
    }

    @NotNull
    public static final <T, R, V> Sequence<V> zip(@NotNull Sequence<? extends T> sequence, @NotNull Sequence<? extends R> sequence2, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sequence2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return new MergingSequence(sequence, sequence2, function2);
    }

    @NotNull
    public static final <T> Sequence<Pair<T, T>> zipWithNext(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return zipWithNext(sequence, SequencesKt___SequencesKt$zipWithNext$1.INSTANCE);
    }

    @NotNull
    public static final <T, R> Sequence<R> zipWithNext(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        return SequencesKt__SequenceBuilderKt.sequence(new SequencesKt___SequencesKt$zipWithNext$2(sequence, function2, null));
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(sequence, appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Sequence<? extends T> sequence, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object next : sequence) {
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
    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(sequence, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Sequence<? extends T> sequence, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static <T> Iterable<T> asIterable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static final double averageOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number byteValue : sequence) {
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

    public static final double averageOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number shortValue : sequence) {
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

    public static final double averageOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number intValue : sequence) {
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

    public static final double averageOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number longValue : sequence) {
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

    public static final double averageOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number floatValue : sequence) {
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

    public static final double averageOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (Number doubleValue : sequence) {
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

    public static final int sumOfByte(@NotNull Sequence<Byte> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        int i = 0;
        for (Number byteValue : sequence) {
            i += byteValue.byteValue();
        }
        return i;
    }

    public static final int sumOfShort(@NotNull Sequence<Short> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        int i = 0;
        for (Number shortValue : sequence) {
            i += shortValue.shortValue();
        }
        return i;
    }

    public static final int sumOfInt(@NotNull Sequence<Integer> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        int i = 0;
        for (Number intValue : sequence) {
            i += intValue.intValue();
        }
        return i;
    }

    public static final long sumOfLong(@NotNull Sequence<Long> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        long j = 0;
        for (Number longValue : sequence) {
            j += longValue.longValue();
        }
        return j;
    }

    public static final float sumOfFloat(@NotNull Sequence<Float> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        float f = 0.0f;
        for (Number floatValue : sequence) {
            f += floatValue.floatValue();
        }
        return f;
    }

    public static final double sumOfDouble(@NotNull Sequence<Double> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Number doubleValue : sequence) {
            d += doubleValue.doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int i = 0;
        for (Object next : sequence) {
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
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (Object next : sequence) {
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
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Sequence<? extends T> sequence, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Object invoke : sequence) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                c.add(invoke2);
            }
        }
        return c;
    }
}
