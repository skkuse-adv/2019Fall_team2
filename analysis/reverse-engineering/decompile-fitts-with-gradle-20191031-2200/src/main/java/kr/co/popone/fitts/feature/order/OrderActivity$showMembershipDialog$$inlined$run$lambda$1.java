package kr.co.popone.fitts.feature.order;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;

final class OrderActivity$showMembershipDialog$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ Membership $membership$inlined;
    final /* synthetic */ Dialog $this_run$inlined;
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$showMembershipDialog$$inlined$run$lambda$1(Dialog dialog, OrderActivity orderActivity, Membership membership) {
        this.$this_run$inlined = dialog;
        this.this$0 = orderActivity;
        this.$membership$inlined = membership;
    }

    public final void onClick(View view) {
        this.this$0.save(this.$membership$inlined.getId(), new Function0<Unit>(this) {
            final /* synthetic */ OrderActivity$showMembershipDialog$$inlined$run$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.$this_run$inlined.dismiss();
            }
        });
    }
}
