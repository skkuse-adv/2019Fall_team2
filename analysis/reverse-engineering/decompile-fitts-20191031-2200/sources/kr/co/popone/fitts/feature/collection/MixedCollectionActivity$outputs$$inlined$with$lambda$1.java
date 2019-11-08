package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$1<T> implements Consumer<Unit> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$1(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.finishActivity();
    }
}
