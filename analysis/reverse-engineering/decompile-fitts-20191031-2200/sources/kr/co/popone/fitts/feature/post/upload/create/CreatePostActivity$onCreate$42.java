package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

final class CreatePostActivity$onCreate$42<T> implements Consumer<ArrayList<String>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$42(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ArrayList<String> arrayList) {
        CreatePostActivity createPostActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "it");
        createPostActivity.checkSelectedStyleTag(arrayList);
    }
}
