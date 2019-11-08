package kr.co.popone.fitts.feature.ncommerce;

import android.view.View;
import android.view.View.OnClickListener;

final class NCommerceActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ NCommerceActivity this$0;

    NCommerceActivity$onCreate$4(NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().handleScheme(this.this$0, "fitts://collection/303?type=mixed");
    }
}
