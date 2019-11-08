package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import org.jetbrains.annotations.NotNull;

final class StoreFragment$onViewCreated$6<T> implements Predicate<Object> {
    public static final StoreFragment$onViewCreated$6 INSTANCE = new StoreFragment$onViewCreated$6();

    StoreFragment$onViewCreated$6() {
    }

    public final boolean test(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return obj instanceof MainEvent$MainTabChangeEvent;
    }
}
