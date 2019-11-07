package kr.co.popone.fitts.viewmodel.search.result;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;

final class SearchResultViewModel$updateFollowState$3<T> implements Consumer<FollowResult> {
    final /* synthetic */ long $userId;
    final /* synthetic */ SearchResultViewModel this$0;

    SearchResultViewModel$updateFollowState$3(SearchResultViewModel searchResultViewModel, long j) {
        this.this$0 = searchResultViewModel;
        this.$userId = j;
    }

    public final void accept(FollowResult followResult) {
        if (followResult != null) {
            this.this$0.sendFollowUpdateEvent(this.$userId, true);
        }
    }
}
