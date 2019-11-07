package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class MixedCollectionViewModel$ViewModel$requestFollow$$inlined$let$lambda$1<T1, T2> implements BiConsumer<FollowResult, Throwable> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ MixedCollectionViewModel$ViewModel this$0;

    MixedCollectionViewModel$ViewModel$requestFollow$$inlined$let$lambda$1(MixedCollectionViewModel$ViewModel mixedCollectionViewModel$ViewModel, int i) {
        this.this$0 = mixedCollectionViewModel$ViewModel;
        this.$index$inlined = i;
    }

    public final void accept(FollowResult followResult, Throwable th) {
        this.this$0.setFollowDisposable(null);
        if (followResult != null) {
            this.this$0.getMixedCollection().updateFollowingUser(this.$index$inlined, true);
            User user = ((CollectionEntry) this.this$0.getMixedCollection().getMixedCollectionEntries().get(this.$index$inlined)).getUser();
            if (user != null) {
                this.this$0.notifyFollowResult(user, true);
                return;
            }
            return;
        }
        this.this$0.getMixedCollection().updateFollowingUser(this.$index$inlined, false);
        this.this$0.getErrorOccur().onNext(th);
    }
}
