package kr.co.popone.fitts.feature.setting;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class FeedbackActivity$showDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$showDialog$1(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.onBackPressed();
    }
}
