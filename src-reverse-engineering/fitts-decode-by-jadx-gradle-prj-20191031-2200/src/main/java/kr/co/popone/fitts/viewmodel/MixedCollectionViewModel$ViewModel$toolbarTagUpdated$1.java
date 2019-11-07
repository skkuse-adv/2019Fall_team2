package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.MixedCollection.ToolbarState;
import org.jetbrains.annotations.NotNull;

final class MixedCollectionViewModel$ViewModel$toolbarTagUpdated$1<T> implements Predicate<ToolbarState> {
    public static final MixedCollectionViewModel$ViewModel$toolbarTagUpdated$1 INSTANCE = new MixedCollectionViewModel$ViewModel$toolbarTagUpdated$1();

    MixedCollectionViewModel$ViewModel$toolbarTagUpdated$1() {
    }

    public final boolean test(@NotNull ToolbarState toolbarState) {
        Intrinsics.checkParameterIsNotNull(toolbarState, "it");
        return toolbarState != ToolbarState.NOT;
    }
}
