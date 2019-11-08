package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import org.jetbrains.annotations.NotNull;

final class MixedCollectionViewModel$ViewModel$bannerLinkUpdated$1<T, R> implements Function<T, R> {
    final /* synthetic */ MixedCollectionViewModel$ViewModel this$0;

    MixedCollectionViewModel$ViewModel$bannerLinkUpdated$1(MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel) {
        this.this$0 = mixedCollectionViewModel$ViewModel;
    }

    @NotNull
    public final CollectionEntry apply(@NotNull Integer num) {
        Intrinsics.checkParameterIsNotNull(num, "it");
        return (CollectionEntry) this.this$0.getMixedCollection().getMixedCollectionEntries().get(num.intValue());
    }
}
