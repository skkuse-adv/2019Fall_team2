package kr.co.popone.fitts.feature;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class WebActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ WebActivity this$0;

    WebActivity$onCreate$4(WebActivity webActivity) {
        this.this$0 = webActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        if (this.this$0.getIntent().getBooleanExtra("join_use", false)) {
            this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
        } else {
            this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
        }
    }
}
