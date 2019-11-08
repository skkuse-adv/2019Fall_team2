package kr.co.popone.fitts.feature.category;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import org.jetbrains.annotations.NotNull;

final class CategorySearchActivity$onCreate$5<T> implements Predicate<MainEvent$MainTabChangeEvent> {
    public static final CategorySearchActivity$onCreate$5 INSTANCE = new CategorySearchActivity$onCreate$5();

    CategorySearchActivity$onCreate$5() {
    }

    public final boolean test(@NotNull MainEvent$MainTabChangeEvent mainEvent$MainTabChangeEvent) {
        Intrinsics.checkParameterIsNotNull(mainEvent$MainTabChangeEvent, "it");
        return mainEvent$MainTabChangeEvent.getTab() == Tab.Store;
    }
}
