package kr.co.popone.fitts.feature.post.upload.create;

import android.view.View;
import android.widget.ScrollView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$54<T> implements Consumer<Integer> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$54(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Integer num) {
        CreatePostActivity createPostActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        View findViewById = createPostActivity.findViewById(num.intValue());
        findViewById.requestFocus();
        ScrollView scrollView = (ScrollView) this.this$0._$_findCachedViewById(C0010R$id.layout_create_post);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view");
        scrollView.smoothScrollTo(0, (int) findViewById.getY());
    }
}
