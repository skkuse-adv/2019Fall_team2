package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$12<T> implements Consumer<Integer> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$12(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Integer num) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.post_title);
        CreatePostActivity createPostActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        editText.setTypeface(ResourcesCompat.getFont(createPostActivity, num.intValue()));
    }
}
