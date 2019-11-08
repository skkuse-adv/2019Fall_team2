package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import org.jetbrains.annotations.NotNull;

final class MixedCollectionViewModel$ViewModel$bannerLinkUpdated$3<T, R> implements Function<T, R> {
    public static final MixedCollectionViewModel$ViewModel$bannerLinkUpdated$3 INSTANCE = new MixedCollectionViewModel$ViewModel$bannerLinkUpdated$3();

    MixedCollectionViewModel$ViewModel$bannerLinkUpdated$3() {
    }

    @NotNull
    public final String apply(@NotNull CollectionEntry collectionEntry) {
        Intrinsics.checkParameterIsNotNull(collectionEntry, "it");
        return collectionEntry.getLink_url();
    }
}
