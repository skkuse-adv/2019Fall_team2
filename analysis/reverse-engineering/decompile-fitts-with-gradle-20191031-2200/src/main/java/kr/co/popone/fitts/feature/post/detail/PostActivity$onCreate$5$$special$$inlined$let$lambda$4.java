package kr.co.popone.fitts.feature.post.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PostActivity$onCreate$5$$special$$inlined$let$lambda$4 implements OnClickListener {
    final /* synthetic */ PostActivity$onCreate$5 this$0;

    PostActivity$onCreate$5$$special$$inlined$let$lambda$4(PostActivity$onCreate$5 postActivity$onCreate$5, Post post) {
        this.this$0 = postActivity$onCreate$5;
    }

    public final void onClick(View view) {
        this.this$0.this$0.hideKeyboard();
        Function0 access$getShowDetailInfoView$p = this.this$0.this$0.showDetailInfoView;
        if (access$getShowDetailInfoView$p != null) {
            Unit unit = (Unit) access$getShowDetailInfoView$p.invoke();
        }
    }
}
