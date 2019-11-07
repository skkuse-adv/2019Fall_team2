package kr.co.popone.fitts.feature.post.detail;

import android.widget.LinearLayout;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class PostActivity$getSameProductPosts$1<T> implements Consumer<List<? extends Post>> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$getSameProductPosts$1(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    public final void accept(List<Post> list) {
        String str = "layoutSamePost";
        if (list.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutSamePost);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
            ViewExtensionsKt.gone(linearLayout);
            return;
        }
        PostActivity postActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(list, "posts");
        postActivity.updateSameProductPost(list);
        LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutSamePost);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.visible(linearLayout2);
    }
}
