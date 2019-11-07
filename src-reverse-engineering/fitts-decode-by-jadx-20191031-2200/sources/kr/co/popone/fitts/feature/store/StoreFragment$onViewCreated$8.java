package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import org.jetbrains.annotations.NotNull;

final class StoreFragment$onViewCreated$8<T> implements Predicate<MainEvent$MainTabChangeEvent> {
    public static final StoreFragment$onViewCreated$8 INSTANCE = new StoreFragment$onViewCreated$8();

    StoreFragment$onViewCreated$8() {
    }

    public final boolean test(@NotNull MainEvent$MainTabChangeEvent mainEvent$MainTabChangeEvent) {
        Intrinsics.checkParameterIsNotNull(mainEvent$MainTabChangeEvent, "it");
        return mainEvent$MainTabChangeEvent.getTab() == Tab.Store;
    }
}
