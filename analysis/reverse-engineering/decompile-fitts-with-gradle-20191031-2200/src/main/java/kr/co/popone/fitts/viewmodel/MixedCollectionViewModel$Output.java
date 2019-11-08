package kr.co.popone.fitts.viewmodel;

import io.reactivex.Observable;
import java.util.ArrayList;
import kotlin.Unit;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.collection.MixedCollection.ToolbarState;
import org.jetbrains.annotations.NotNull;

public interface MixedCollectionViewModel$Output {
    @NotNull
    Observable<String> bannerLinkUpdated();

    @NotNull
    Observable<CollectionDetailResponse> collectionDetailUpdated();

    @NotNull
    Observable<ArrayList<CollectionEntry>> collectionListAdded();

    @NotNull
    Observable<ArrayList<CollectionEntry>> collectionListUpdated();

    @NotNull
    Observable<Unit> finishActivity();

    @NotNull
    Observable<Boolean> loadingViewUpdated();

    @NotNull
    Observable<Throwable> onErrorOccured();

    @NotNull
    Observable<Long> showRoomUpdated();

    @NotNull
    Observable<ToolbarState> toolbarTagUpdated();
}
