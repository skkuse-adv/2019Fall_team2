package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.post.upload.posting.PostingActivityUiExtensionKt;

final class CreatePostActivity$onCreate$58<T> implements Consumer<Integer> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$58(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.post_images_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "post_images_title");
        CreatePostActivity createPostActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        PostingActivityUiExtensionKt.setTextColor(textView, createPostActivity, num.intValue());
    }
}
