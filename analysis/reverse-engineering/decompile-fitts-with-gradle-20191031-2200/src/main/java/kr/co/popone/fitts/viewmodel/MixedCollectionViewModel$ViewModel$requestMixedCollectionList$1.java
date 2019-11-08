package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;

final class MixedCollectionViewModel$ViewModel$requestMixedCollectionList$1<T1, T2> implements BiConsumer<List<? extends CollectionEntry>, Throwable> {
    final /* synthetic */ boolean $reload;
    final /* synthetic */ MixedCollectionViewModel$ViewModel this$0;

    MixedCollectionViewModel$ViewModel$requestMixedCollectionList$1(MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel, boolean z) {
        this.this$0 = mixedCollectionViewModel$ViewModel;
        this.$reload = z;
    }

    public final void accept(List<CollectionEntry> list, Throwable th) {
        this.this$0.setCollectionListDisposable(null);
        if (list != null) {
            if (this.$reload) {
                this.this$0.getMixedCollection().addAllMixedCollectionEntriesWithClear(new ArrayList(list));
                this.this$0.getCollectionList().onNext(new ArrayList(list));
            } else {
                this.this$0.getMixedCollection().addAllMixedCollectionEntries(new ArrayList(list));
                this.this$0.getCollectionAddedList().onNext(new ArrayList(list));
            }
            this.this$0.setHasMore(list.size() >= 20);
        } else {
            this.this$0.getErrorOccur().onNext(th);
        }
        this.this$0.isLoading().onNext(Boolean.valueOf(false));
    }
}
