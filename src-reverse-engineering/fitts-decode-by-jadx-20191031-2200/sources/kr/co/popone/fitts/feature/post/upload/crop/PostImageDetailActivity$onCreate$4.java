package kr.co.popone.fitts.feature.post.upload.crop;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;
import kr.co.popone.fitts.C0001R$anim;

final class PostImageDetailActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ PostImageDetailActivity this$0;

    PostImageDetailActivity$onCreate$4(PostImageDetailActivity postImageDetailActivity) {
        this.this$0 = postImageDetailActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("post_detail_data", this.this$0.getImages());
        StringBuilder sb = new StringBuilder();
        sb.append("PostImageDetailActivity complete_button clicked with ");
        sb.append(this.this$0.getImages());
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.setResult(-1, intent);
        this.this$0.hideKeyboard();
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
