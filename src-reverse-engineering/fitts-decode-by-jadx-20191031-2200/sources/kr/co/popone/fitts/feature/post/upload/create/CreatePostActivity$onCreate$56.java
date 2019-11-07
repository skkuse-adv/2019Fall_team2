package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.post.upload.posting.PostingActivityUiExtensionKt;

final class CreatePostActivity$onCreate$56<T> implements Consumer<Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$56(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Pair<Integer, Integer> pair) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.post_cover_image_insert_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "post_cover_image_insert_button");
        PostingActivityUiExtensionKt.setTextColor(button, this.this$0, ((Number) pair.getSecond()).intValue());
        ((Button) this.this$0._$_findCachedViewById(C0010R$id.post_cover_image_insert_button)).setCompoundDrawablesWithIntrinsicBounds(((Number) pair.getFirst()).intValue(), 0, 0, 0);
    }
}
