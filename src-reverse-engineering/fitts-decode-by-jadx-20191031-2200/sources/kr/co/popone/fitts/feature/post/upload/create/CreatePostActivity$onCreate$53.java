package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kr.co.popone.fitts.model.post.PostDetailImage;

final class CreatePostActivity$onCreate$53<T> implements Consumer<ArrayList<PostDetailImage>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$53(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ArrayList<PostDetailImage> arrayList) {
        this.this$0.getViewModel().detailImageReLoad();
    }
}
