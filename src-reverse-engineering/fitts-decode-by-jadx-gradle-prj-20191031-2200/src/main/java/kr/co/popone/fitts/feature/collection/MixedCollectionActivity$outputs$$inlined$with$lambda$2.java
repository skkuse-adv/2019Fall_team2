package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.MixedCollection.ToolbarState;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$2<T> implements Consumer<ToolbarState> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$2(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(ToolbarState toolbarState) {
        MixedCollectionActivity mixedCollectionActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(toolbarState, "it");
        mixedCollectionActivity.updateToolbarUI(toolbarState);
    }
}
