package kr.co.popone.fitts.feature.setting;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class FeedbackActivity$requestFeedback$2<T> implements Consumer<Throwable> {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$requestFeedback$2(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.feedbackRequest = null;
        this.this$0.onFeedbackRequestEnd();
        StringBuilder sb = new StringBuilder();
        sb.append("error occurred ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
