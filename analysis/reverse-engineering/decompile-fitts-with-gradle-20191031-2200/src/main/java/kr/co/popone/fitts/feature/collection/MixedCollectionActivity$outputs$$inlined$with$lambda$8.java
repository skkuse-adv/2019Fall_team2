package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$8<T> implements Consumer<Throwable> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$8(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(Throwable th) {
        MixedCollectionActivity mixedCollectionActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(th, "it");
        mixedCollectionActivity.handleError(th);
    }
}
