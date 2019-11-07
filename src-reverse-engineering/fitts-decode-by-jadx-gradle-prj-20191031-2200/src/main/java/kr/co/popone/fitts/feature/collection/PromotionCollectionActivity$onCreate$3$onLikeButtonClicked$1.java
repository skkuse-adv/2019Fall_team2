package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;

final class PromotionCollectionActivity$onCreate$3$onLikeButtonClicked$1<T1, T2> implements BiConsumer<LikeResult, Throwable> {
    final /* synthetic */ long $postID;
    final /* synthetic */ PromotionCollectionActivity$onCreate$3 this$0;

    PromotionCollectionActivity$onCreate$3$onLikeButtonClicked$1(PromotionCollectionActivity$onCreate$3 promotionCollectionActivity$onCreate$3, long j) {
        this.this$0 = promotionCollectionActivity$onCreate$3;
        this.$postID = j;
    }

    public final void accept(LikeResult likeResult, Throwable th) {
        this.this$0.this$0.postLikeRequests.remove(Long.valueOf(this.$postID));
        if (likeResult != null) {
            this.this$0.this$0.updateListForLikes(this.$postID, false);
        }
    }
}
