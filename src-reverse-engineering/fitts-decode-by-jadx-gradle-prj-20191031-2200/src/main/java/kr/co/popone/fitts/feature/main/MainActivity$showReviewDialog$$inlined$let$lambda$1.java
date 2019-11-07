package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.appreview.AppReview;

final class MainActivity$showReviewDialog$$inlined$let$lambda$1<T> implements Consumer<Long> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$showReviewDialog$$inlined$let$lambda$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(Long l) {
        this.this$0.reviewTimerRequest = null;
        AppReview.INSTANCE.showFirstReviewDialog(this.this$0);
    }
}
