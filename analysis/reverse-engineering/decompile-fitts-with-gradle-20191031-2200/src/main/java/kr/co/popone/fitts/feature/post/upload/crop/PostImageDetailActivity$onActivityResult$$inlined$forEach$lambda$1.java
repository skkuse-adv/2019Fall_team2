package kr.co.popone.fitts.feature.post.upload.crop;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class PostImageDetailActivity$onActivityResult$$inlined$forEach$lambda$1 implements Runnable {
    final /* synthetic */ PostImageDetailActivity this$0;

    PostImageDetailActivity$onActivityResult$$inlined$forEach$lambda$1(PostImageDetailActivity postImageDetailActivity, String str) {
        this.this$0 = postImageDetailActivity;
    }

    public final void run() {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.detail_post_list);
        Integer access$getChangedPosition$p = this.this$0.changedPosition;
        if (access$getChangedPosition$p == null) {
            Intrinsics.throwNpe();
        }
        recyclerView.scrollToPosition(access$getChangedPosition$p.intValue());
    }
}
