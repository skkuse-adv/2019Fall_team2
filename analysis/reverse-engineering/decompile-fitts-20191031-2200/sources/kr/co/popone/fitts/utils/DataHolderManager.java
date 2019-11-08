package kr.co.popone.fitts.utils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DataHolderManager {
    private final ConcurrentHashMap<String, List<?>> map = new ConcurrentHashMap<>();

    public final void putListData(@NotNull String str, @NotNull List<?> list) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.map.put(str, list);
    }

    public final void popListData(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.map.remove(str);
    }

    @Nullable
    public final List<?> getListData(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return (List) this.map.get(str);
    }
}
