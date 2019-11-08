package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;

final class CreatePostActivity$onCreate$13<T> implements Consumer<Float> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$13(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Float f) {
        CreatePostViewModel viewModel = this.this$0.getViewModel();
        Intrinsics.checkExpressionValueIsNotNull(f, "it");
        viewModel.ratingChanged(f.floatValue());
    }
}
