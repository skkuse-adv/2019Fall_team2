package kotlin.collections;

import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class MapsKt___MapsKt extends MapsKt__MapsKt {
    @NotNull
    public static final <K, V> List<Pair<K, V>> toList(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        if (map.size() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Entry entry = (Entry) it.next();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsJVMKt.listOf(new Pair(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        do {
            Entry entry2 = (Entry) it.next();
            arrayList.add(new Pair(entry2.getKey(), entry2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    @NotNull
    public static final <K, V, R> List<R> flatMap(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Entry invoke : map.entrySet()) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Entry invoke : map.entrySet()) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <K, V, R> List<R> map(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry invoke : map.entrySet()) {
            arrayList.add(function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R> List<R> mapNotNull(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (Entry invoke : map.entrySet()) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Entry invoke : map.entrySet()) {
            c.add(function1.invoke(invoke));
        }
        return c;
    }

    public static final <K, V> boolean all(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Entry invoke : map.entrySet()) {
            if (!((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        return !map.isEmpty();
    }

    public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        for (Entry invoke : map.entrySet()) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> int count(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        if (map.isEmpty()) {
            return 0;
        }
        for (Entry invoke : map.entrySet()) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final <K, V> void forEach(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (Entry invoke : map.entrySet()) {
            function1.invoke(invoke);
        }
    }

    @Nullable
    public static final <K, V, R extends Comparable<? super R>> Entry<K, V> minBy(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            Comparable comparable = (Comparable) function1.invoke(next);
            while (it.hasNext()) {
                Object next2 = it.next();
                Comparable comparable2 = (Comparable) function1.invoke(next2);
                if (comparable.compareTo(comparable2) > 0) {
                    next = next2;
                    comparable = comparable2;
                }
            }
            obj = next;
        }
        return (Entry) obj;
    }

    @Nullable
    public static final <K, V> Entry<K, V> minWith(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (Entry) CollectionsKt___CollectionsKt.minWith(map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        return map.isEmpty();
    }

    public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Entry invoke : map.entrySet()) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(@NotNull M m, @NotNull Function1<? super Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(m, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (Entry invoke : m.entrySet()) {
            function1.invoke(invoke);
        }
        return m;
    }

    @NotNull
    public static final <K, V> Sequence<Entry<K, V>> asSequence(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        return CollectionsKt___CollectionsKt.asSequence(map.entrySet());
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (Entry invoke : map.entrySet()) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                c.add(invoke2);
            }
        }
        return c;
    }
}
