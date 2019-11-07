package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;

final class CreatePostActivity$onCreate$34<T> implements Consumer<String> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$34(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(String str) {
        CreatePostViewModel viewModel = this.this$0.getViewModel();
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        viewModel.coverImageChanged(str);
    }
}
