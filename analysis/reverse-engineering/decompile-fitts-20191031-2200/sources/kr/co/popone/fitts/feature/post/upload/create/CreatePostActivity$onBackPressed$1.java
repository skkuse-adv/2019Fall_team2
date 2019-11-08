package kr.co.popone.fitts.feature.post.upload.create;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class CreatePostActivity$onBackPressed$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onBackPressed$1(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.showFinishDialog();
        } else {
            this.this$0.finish();
        }
    }
}
