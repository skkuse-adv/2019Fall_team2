package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class EventShopWebActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ EventShopWebActivity this$0;

    EventShopWebActivity$onCreate$3(EventShopWebActivity eventShopWebActivity) {
        this.this$0 = eventShopWebActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
