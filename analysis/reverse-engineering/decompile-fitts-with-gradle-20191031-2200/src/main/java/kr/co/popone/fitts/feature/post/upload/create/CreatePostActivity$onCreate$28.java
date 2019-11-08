package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$28<T> implements Consumer<String> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$28(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(String str) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText(str);
    }
}
