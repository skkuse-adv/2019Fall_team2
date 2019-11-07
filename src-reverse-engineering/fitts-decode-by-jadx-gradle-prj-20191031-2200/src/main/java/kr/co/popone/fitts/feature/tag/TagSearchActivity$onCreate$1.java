package kr.co.popone.fitts.feature.tag;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class TagSearchActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ TagSearchActivity this$0;

    TagSearchActivity$onCreate$1(TagSearchActivity tagSearchActivity) {
        this.this$0 = tagSearchActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
