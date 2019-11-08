package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.EditText;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationEditDrawable;

final class CreatePostActivity$onCreate$55<T> implements Consumer<ValidationEditDrawable> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$55(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ValidationEditDrawable validationEditDrawable) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.post_title);
        Intrinsics.checkExpressionValueIsNotNull(editText, "post_title");
        editText.setBackground(ContextCompat.getDrawable(this.this$0, validationEditDrawable.getDrawable()));
    }
}
