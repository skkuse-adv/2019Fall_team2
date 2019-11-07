package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$20<T> implements Consumer<Boolean> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$20(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.showUrlLinkButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "showUrlLinkButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        button.setEnabled(bool.booleanValue());
    }
}
