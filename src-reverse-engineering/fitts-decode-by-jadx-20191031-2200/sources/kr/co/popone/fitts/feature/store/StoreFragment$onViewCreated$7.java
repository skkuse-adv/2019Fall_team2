package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import org.jetbrains.annotations.NotNull;

final class StoreFragment$onViewCreated$7<T, R> implements Function<T, R> {
    public static final StoreFragment$onViewCreated$7 INSTANCE = new StoreFragment$onViewCreated$7();

    StoreFragment$onViewCreated$7() {
    }

    @NotNull
    public final MainEvent$MainTabChangeEvent apply(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return (MainEvent$MainTabChangeEvent) obj;
    }
}
