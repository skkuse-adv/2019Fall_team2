package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$65<T> implements Consumer<Integer> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$65(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.shopBlacklistNoticeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "shopBlacklistNoticeTextView");
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        textView.setVisibility(num.intValue());
    }
}
