package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;

final class MixedCollectionViewModel$ViewModel$requestMixedCollectionDetail$1<T1, T2> implements BiConsumer<CollectionDetailResponse, Throwable> {
    final /* synthetic */ MixedCollectionViewModel$ViewModel this$0;

    MixedCollectionViewModel$ViewModel$requestMixedCollectionDetail$1(MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel) {
        this.this$0 = mixedCollectionViewModel$ViewModel;
    }

    public final void accept(CollectionDetailResponse collectionDetailResponse, Throwable th) {
        this.this$0.setCollectionDetailDisposable(null);
        if (collectionDetailResponse != null) {
            this.this$0.getCollectionDetail().onNext(collectionDetailResponse);
        } else {
            this.this$0.getErrorOccur().onNext(th);
        }
        this.this$0.requestMixedCollectionList(true);
    }
}
