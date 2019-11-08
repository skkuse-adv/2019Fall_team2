package kr.co.popone.fitts.feature.post.detail;

import android.widget.LinearLayout;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class PostActivity$getRelatedPost$2<T> implements Consumer<Throwable> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$getRelatedPost$2(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    public final void accept(Throwable th) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutRelatedPost);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "layoutRelatedPost");
        ViewExtensionsKt.gone(linearLayout);
    }
}
