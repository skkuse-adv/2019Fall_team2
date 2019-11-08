package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(@NotNull Map<K, ? extends V> map, K k) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(k);
        sb.append(" is missing in the map.");
        throw new NoSuchElementException(sb.toString());
    }

    @NotNull
    public static final <K, V> Map<K, V> withDefault(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "defaultValue");
        if (map instanceof MapWithDefault) {
            return withDefault(((MapWithDefault) map).getMap(), function1);
        }
        return new MapWithDefaultImpl(map, function1);
    }

    @NotNull
    public static final <K, V> Map<K, V> withDefaultMutable(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(map, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "defaultValue");
        if (map instanceof MutableMapWithDefault) {
            return withDefaultMutable(((MutableMapWithDefault) map).getMap(), function1);
        }
        return new MutableMapWithDefaultImpl(map, function1);
    }
}
