package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.post.upload.posting.PostingActivityUiExtensionKt;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;

final class CreatePostActivity$onCreate$63<T> implements Consumer<ValidationTextColor> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$63(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ValidationTextColor validationTextColor) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.about_size_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "about_size_title");
        PostingActivityUiExtensionKt.setTextColor(textView, this.this$0, validationTextColor.getCaptionColor());
    }
}
