package kr.co.popone.fitts.feature.post;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PostingViolationNoticeActivity$postInvoiceID$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ PostingViolationNoticeActivity this$0;

    PostingViolationNoticeActivity$postInvoiceID$2(PostingViolationNoticeActivity postingViolationNoticeActivity) {
        this.this$0 = postingViolationNoticeActivity;
        super(0);
    }

    public final long invoke() {
        long longExtra = this.this$0.getIntent().getLongExtra("id", 0);
        if (longExtra != 0) {
            return longExtra;
        }
        throw new IllegalAccessException();
    }
}
