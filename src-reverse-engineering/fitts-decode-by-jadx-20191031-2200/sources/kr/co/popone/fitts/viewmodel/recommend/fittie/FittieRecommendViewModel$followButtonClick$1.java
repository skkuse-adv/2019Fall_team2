package kr.co.popone.fitts.viewmodel.recommend.fittie;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;

final class FittieRecommendViewModel$followButtonClick$1<T1, T2> implements BiConsumer<FollowResult, Throwable> {
    final /* synthetic */ long $id;
    final /* synthetic */ FittieRecommendViewModel this$0;

    FittieRecommendViewModel$followButtonClick$1(FittieRecommendViewModel fittieRecommendViewModel, long j) {
        this.this$0 = fittieRecommendViewModel;
        this.$id = j;
    }

    public final void accept(FollowResult followResult, Throwable th) {
        if (followResult != null) {
            this.this$0.postFollowStateChangeEvent(this.$id, true);
            FittieRecommendViewModel fittieRecommendViewModel = this.this$0;
            fittieRecommendViewModel.set_followingCount(fittieRecommendViewModel.get_followingCount() + 1);
            return;
        }
        this.this$0.getErrorLiveData().setValue(th);
    }
}
