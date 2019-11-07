package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class ModifyProfileActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ ModifyProfileActivity this$0;

    ModifyProfileActivity$onCreate$1(ModifyProfileActivity modifyProfileActivity) {
        this.this$0 = modifyProfileActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
