package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class CreatePostActivity$onCreate$8<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$8(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().closeButtonClicked(new Function1<Boolean, Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$8 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    this.this$0.this$0.showFinishDialog();
                } else {
                    this.this$0.this$0.finish();
                }
            }
        });
    }
}
