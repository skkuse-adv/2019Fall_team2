package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class ModifyShowRoomActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ ModifyShowRoomActivity this$0;

    ModifyShowRoomActivity$onCreate$1(ModifyShowRoomActivity modifyShowRoomActivity) {
        this.this$0 = modifyShowRoomActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
