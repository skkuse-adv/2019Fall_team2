package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;

final class CreatePostActivity$onCreate$17<T> implements Consumer<CharSequence> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$17(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(CharSequence charSequence) {
        this.this$0.getViewModel().aboutSizeTextChanged(charSequence.toString());
    }
}
