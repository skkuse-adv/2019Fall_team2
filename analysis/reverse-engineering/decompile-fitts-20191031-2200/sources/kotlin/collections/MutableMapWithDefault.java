package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V>, KMutableMap {
    @NotNull
    Map<K, V> getMap();
}
