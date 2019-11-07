package kr.co.popone.fitts.utils;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ListUtilsKt {
    @NotNull
    public static final List<String> listUniqueInsert(@NotNull List<String> list, @NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "string");
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection<? extends T>) list);
        mutableList.remove(str);
        mutableList.add(0, str);
        if (i >= mutableList.size()) {
            i = mutableList.size();
        }
        return mutableList.subList(0, i);
    }
}
