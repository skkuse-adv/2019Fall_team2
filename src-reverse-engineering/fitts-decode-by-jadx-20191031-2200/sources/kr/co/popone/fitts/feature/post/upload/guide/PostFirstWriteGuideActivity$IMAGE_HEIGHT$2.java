package kr.co.popone.fitts.feature.post.upload.guide;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PostFirstWriteGuideActivity$IMAGE_HEIGHT$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PostFirstWriteGuideActivity this$0;

    PostFirstWriteGuideActivity$IMAGE_HEIGHT$2(PostFirstWriteGuideActivity postFirstWriteGuideActivity) {
        this.this$0 = postFirstWriteGuideActivity;
        super(0);
    }

    public final int invoke() {
        double access$getSCREEN_WIDTH$p = (double) this.this$0.getSCREEN_WIDTH();
        double access$getIMAGE_RATIO$p = this.this$0.IMAGE_RATIO;
        Double.isNaN(access$getSCREEN_WIDTH$p);
        return (int) (access$getSCREEN_WIDTH$p * access$getIMAGE_RATIO$p);
    }
}
