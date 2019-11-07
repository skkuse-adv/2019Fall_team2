package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class ShowRoomActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onCreate$2(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
