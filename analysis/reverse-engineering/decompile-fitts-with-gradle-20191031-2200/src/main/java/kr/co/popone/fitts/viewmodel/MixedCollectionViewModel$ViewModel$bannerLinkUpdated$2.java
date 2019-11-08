package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionType;
import org.jetbrains.annotations.NotNull;

final class MixedCollectionViewModel$ViewModel$bannerLinkUpdated$2<T> implements Predicate<CollectionEntry> {
    public static final MixedCollectionViewModel$ViewModel$bannerLinkUpdated$2 INSTANCE = new MixedCollectionViewModel$ViewModel$bannerLinkUpdated$2();

    MixedCollectionViewModel$ViewModel$bannerLinkUpdated$2() {
    }

    public final boolean test(@NotNull CollectionEntry collectionEntry) {
        Intrinsics.checkParameterIsNotNull(collectionEntry, "it");
        return collectionEntry.getType() == CollectionType.IMAGE;
    }
}