package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.tag.TagGroup;

final class CreatePostActivity$onCreate$44<T> implements Consumer<ArrayList<String>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$44(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(ArrayList<String> arrayList) {
        ((TagGroup) this.this$0._$_findCachedViewById(C0010R$id.tag_create_post)).setTags((List<String>) arrayList);
    }
}
