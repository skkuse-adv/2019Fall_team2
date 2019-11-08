package kr.co.popone.fitts.feature.setting;

import io.reactivex.functions.Action;

final class FeedbackActivity$requestFeedback$1 implements Action {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$requestFeedback$1(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public final void run() {
        this.this$0.feedbackRequest = null;
        this.this$0.onFeedbackRequestEnd();
        this.this$0.showDialog();
    }
}
