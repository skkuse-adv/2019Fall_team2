package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class MixedCollectionViewModel$ViewModel$showRoomUpdated$3<T, R> implements Function<T, R> {
    public static final MixedCollectionViewModel$ViewModel$showRoomUpdated$3 INSTANCE = new MixedCollectionViewModel$ViewModel$showRoomUpdated$3();

    MixedCollectionViewModel$ViewModel$showRoomUpdated$3() {
    }

    @Nullable
    public final Long apply(@NotNull CollectionEntry collectionEntry) {
        Intrinsics.checkParameterIsNotNull(collectionEntry, "it");
        User user = collectionEntry.getUser();
        if (user != null) {
            return Long.valueOf(user.getId());
        }
        return null;
    }
}
