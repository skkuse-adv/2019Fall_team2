package kr.co.popone.fitts.feature.reward;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class RewardPointUseActivity$loadUsablePoint$2<T> implements Consumer<Throwable> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$loadUsablePoint$2(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
