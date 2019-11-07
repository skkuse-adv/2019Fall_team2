package kr.co.popone.fitts.feature.category;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import org.jetbrains.annotations.NotNull;

final class CategorySearchActivity$onCreate$3<T> implements Predicate<Object> {
    public static final CategorySearchActivity$onCreate$3 INSTANCE = new CategorySearchActivity$onCreate$3();

    CategorySearchActivity$onCreate$3() {
    }

    public final boolean test(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return obj instanceof MainEvent$MainTabChangeEvent;
    }
}
