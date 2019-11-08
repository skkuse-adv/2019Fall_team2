package kr.co.popone.fitts.feature.post.upload.preview;

import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostPreviewActivity$onCreate$1$1$$special$$inlined$run$lambda$1 implements Delegate {
    final /* synthetic */ LinkInfo $linkInfoResult$inlined;
    final /* synthetic */ AnonymousClass1 this$0;

    PostPreviewActivity$onCreate$1$1$$special$$inlined$run$lambda$1(AnonymousClass1 r1, LinkInfo linkInfo) {
        this.this$0 = r1;
        this.$linkInfoResult$inlined = linkInfo;
    }

    @NotNull
    public CreatePost getPreviewPost() {
        return this.this$0.this$0.$createPost;
    }

    @NotNull
    public MyInfo getUserInfo() {
        return r3;
    }

    @Nullable
    public LinkInfo getLinkInfo() {
        return this.$linkInfoResult$inlined;
    }
}
