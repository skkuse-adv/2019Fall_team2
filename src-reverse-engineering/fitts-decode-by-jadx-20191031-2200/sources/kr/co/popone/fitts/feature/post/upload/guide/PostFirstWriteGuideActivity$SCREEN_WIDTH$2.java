package kr.co.popone.fitts.feature.post.upload.guide;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import photopicker.utils.ScreenUtilsKt;

final class PostFirstWriteGuideActivity$SCREEN_WIDTH$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PostFirstWriteGuideActivity this$0;

    PostFirstWriteGuideActivity$SCREEN_WIDTH$2(PostFirstWriteGuideActivity postFirstWriteGuideActivity) {
        this.this$0 = postFirstWriteGuideActivity;
        super(0);
    }

    public final int invoke() {
        return ScreenUtilsKt.screenWidth(this.this$0);
    }
}
