package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;

final class PromotionCollectionActivity$onCreate$3$onFollowButtonClicked$1<T1, T2> implements BiConsumer<FollowResult, Throwable> {
    final /* synthetic */ long $userID;
    final /* synthetic */ PromotionCollectionActivity$onCreate$3 this$0;

    PromotionCollectionActivity$onCreate$3$onFollowButtonClicked$1(PromotionCollectionActivity$onCreate$3 promotionCollectionActivity$onCreate$3, long j) {
        this.this$0 = promotionCollectionActivity$onCreate$3;
        this.$userID = j;
    }

    public final void accept(FollowResult followResult, Throwable th) {
        this.this$0.this$0.fittieFollowRequests.remove(Long.valueOf(this.$userID));
        if (followResult != null) {
            this.this$0.this$0.updateListForFollow(this.$userID, false);
        }
    }
}
