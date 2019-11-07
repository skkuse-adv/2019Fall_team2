package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kr.co.popone.fitts.utils.ButtonExtensionsKt;

final class CreatePostActivity$onCreate$67<T> implements Consumer<Pair<? extends Integer, ? extends Boolean>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$67(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Pair<Integer, Boolean> pair) {
        Button button = (Button) this.this$0.getStyleButtons().get(((Number) pair.getFirst()).intValue());
        button.setSelected(((Boolean) pair.getSecond()).booleanValue());
        ButtonExtensionsKt.updateStyleButton(button);
        this.this$0.getViewModel().isStyleButtonValidate();
    }
}
