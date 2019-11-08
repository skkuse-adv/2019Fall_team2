package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$6<T> implements Consumer<Long> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$6(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(Long l) {
        MixedCollectionActivity mixedCollectionActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(l, "it");
        mixedCollectionActivity.profileHolderClicked(l.longValue());
    }
}
