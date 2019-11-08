package kr.co.popone.fitts.feature.post.detail;

import java.util.List;
import kr.co.popone.fitts.feature.post.detail.PostAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import org.jetbrains.annotations.NotNull;

public final class PostActivity$onActivityResult$1$$special$$inlined$run$lambda$3 implements Delegate {
    final /* synthetic */ PostActivity$onActivityResult$1 this$0;

    PostActivity$onActivityResult$1$$special$$inlined$run$lambda$3(PostActivity$onActivityResult$1 postActivity$onActivityResult$1) {
        this.this$0 = postActivity$onActivityResult$1;
    }

    @NotNull
    public List<Image> getImageList() {
        return this.this$0.this$0.postImageList;
    }
}
