package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$16<T> implements Consumer<Boolean> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$16(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Boolean bool) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.about_product_hint);
        Intrinsics.checkExpressionValueIsNotNull(textView, "about_product_hint");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        textView.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
