package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class ModifyBodyActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$1(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
