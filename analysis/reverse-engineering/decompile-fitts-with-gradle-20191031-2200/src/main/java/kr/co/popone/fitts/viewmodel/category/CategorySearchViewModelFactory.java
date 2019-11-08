package kr.co.popone.fitts.viewmodel.category;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import org.jetbrains.annotations.NotNull;

public final class CategorySearchViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final EventTracker eventTracker;

    public CategorySearchViewModelFactory(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new CategorySearchViewModel(this.eventTracker);
    }
}
