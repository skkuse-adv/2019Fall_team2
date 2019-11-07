package kr.co.popone.fitts.feature.post.detail;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PostActivity$defaultPostId$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$defaultPostId$2(PostActivity postActivity) {
        this.this$0 = postActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra("post_id", -1);
    }
}
