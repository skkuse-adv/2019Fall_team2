package kr.co.popone.fitts.feature.post.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.post.PostType;

final class PostTypeSelectDialog$initView$3 implements OnClickListener {
    final /* synthetic */ PostTypeSelectDialog this$0;

    PostTypeSelectDialog$initView$3(PostTypeSelectDialog postTypeSelectDialog) {
        this.this$0 = postTypeSelectDialog;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onNewPostClicked(PostType.CLOTHES);
    }
}
