package kr.co.popone.fitts.feature.post.upload.preview;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity.PreviewType;
import org.jetbrains.annotations.NotNull;

final class PostPreviewActivity$previewType$2 extends Lambda implements Function0<PreviewType> {
    final /* synthetic */ PostPreviewActivity this$0;

    PostPreviewActivity$previewType$2(PostPreviewActivity postPreviewActivity) {
        this.this$0 = postPreviewActivity;
        super(0);
    }

    @NotNull
    public final PreviewType invoke() {
        return this.this$0.getIntent().getBooleanExtra("modify_post", false) ? PreviewType.UpdatePost : PreviewType.CreatePost;
    }
}
