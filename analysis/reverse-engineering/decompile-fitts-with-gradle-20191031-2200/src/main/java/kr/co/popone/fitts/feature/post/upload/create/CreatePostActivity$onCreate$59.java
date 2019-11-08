package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostDetailImage;

final class CreatePostActivity$onCreate$59<T> implements Consumer<ArrayList<PostDetailImage>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$59(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ArrayList<PostDetailImage> arrayList) {
        CreatePostImageAdapter createPostImageAdapter = this.this$0.getCreatePostImageAdapter();
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "it");
        createPostImageAdapter.addAll(arrayList);
        this.this$0.getViewModel().isDetailImageValidate();
    }
}
