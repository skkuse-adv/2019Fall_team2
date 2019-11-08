package kotlin.collections;

import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class MutableMapWithDefaultImpl<K, V> implements MutableMapWithDefault<K, V> {

    /* renamed from: default reason: not valid java name */
    private final Function1<K, V> f2default;
    @NotNull
    private final Map<K, V> map;

    public MutableMapWithDefaultImpl(@NotNull Map<K, V> map2, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(map2, "map");
        Intrinsics.checkParameterIsNotNull(function1, KakaoTalkLinkProtocol.VALIDATION_DEFAULT);
        this.map = map2;
        this.f2default = function1;
    }

    public final /* bridge */ Set<Entry<K, V>> entrySet() {
        return getEntries();
    }

    @NotNull
    public Map<K, V> getMap() {
        return this.map;
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public boolean equals(@Nullable Object obj) {
        return getMap().equals(obj);
    }

    public int hashCode() {
        return getMap().hashCode();
    }

    @NotNull
    public String toString() {
        return getMap().toString();
    }

    public int getSize() {
        return getMap().size();
    }

    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    @Nullable
    public V get(Object obj) {
        return getMap().get(obj);
    }

    @NotNull
    public Set<K> getKeys() {
        return getMap().keySet();
    }

    @NotNull
    public Collection<V> getValues() {
        return getMap().values();
    }

    @NotNull
    public Set<Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    @Nullable
    public V put(K k, V v) {
        return getMap().put(k, v);
    }

    @Nullable
    public V remove(Object obj) {
        return getMap().remove(obj);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map2) {
        Intrinsics.checkParameterIsNotNull(map2, "from");
        getMap().putAll(map2);
    }

    public void clear() {
        getMap().clear();
    }

    public V getOrImplicitDefault(K k) {
        Map map2 = getMap();
        V v = map2.get(k);
        return (v != null || map2.containsKey(k)) ? v : this.f2default.invoke(k);
    }
}
