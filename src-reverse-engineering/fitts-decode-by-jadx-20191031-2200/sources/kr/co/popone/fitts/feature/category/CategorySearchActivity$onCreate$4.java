package kr.co.popone.fitts.feature.category;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import org.jetbrains.annotations.NotNull;

final class CategorySearchActivity$onCreate$4<T, R> implements Function<T, R> {
    public static final CategorySearchActivity$onCreate$4 INSTANCE = new CategorySearchActivity$onCreate$4();

    CategorySearchActivity$onCreate$4() {
    }

    @NotNull
    public final MainEvent$MainTabChangeEvent apply(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return (MainEvent$MainTabChangeEvent) obj;
    }
}
