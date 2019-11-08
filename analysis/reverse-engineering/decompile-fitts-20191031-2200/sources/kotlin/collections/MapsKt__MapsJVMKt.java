package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    @NotNull
    public static <K, V> Map<K, V> mapOf(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> V getOrPut(@NotNull ConcurrentMap<K, V> concurrentMap, K k, @NotNull Function0<? extends V> function0) {
        Intrinsics.checkParameterIsNotNull(concurrentMap, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V invoke = function0.invoke();
        Object putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
        return putIfAbsent != null ? putIfAbsent : invoke;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        return new TreeMap(map);
    }

    @NotNull
    public static final <K, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        TreeMap treeMap = new TreeMap();
        MapsKt__MapsKt.putAll((Map<? super K, ? super V>) treeMap, pairArr);
        return treeMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> toSingletonMap(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Entry entry = (Entry) map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "java.util.Collections.singletonMap(key, value)");
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
