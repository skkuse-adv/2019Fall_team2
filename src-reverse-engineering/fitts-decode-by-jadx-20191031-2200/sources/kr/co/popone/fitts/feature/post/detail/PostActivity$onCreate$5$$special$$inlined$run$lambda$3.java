package kr.co.popone.fitts.feature.post.detail;

import java.util.List;
import kr.co.popone.fitts.feature.post.detail.PostAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import org.jetbrains.annotations.NotNull;

public final class PostActivity$onCreate$5$$special$$inlined$run$lambda$3 implements Delegate {
    final /* synthetic */ PostActivity$onCreate$5 this$0;

    PostActivity$onCreate$5$$special$$inlined$run$lambda$3(PostActivity$onCreate$5 postActivity$onCreate$5) {
        this.this$0 = postActivity$onCreate$5;
    }

    @NotNull
    public List<Image> getImageList() {
        return this.this$0.this$0.postImageList;
    }
}
