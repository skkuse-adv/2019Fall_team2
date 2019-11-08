package kr.co.popone.fitts.feature.order;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.constraintlayout.widget.Group;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class OrderActivity$onCreate$34 implements OnCheckedChangeListener {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$34(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str = "groupCacheReceiptUi";
        switch (i) {
            case C0010R$id.radioPublishRecept /*2131362749*/:
                Group group = (Group) this.this$0._$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
                Intrinsics.checkExpressionValueIsNotNull(group, str);
                group.setVisibility(0);
                return;
            case C0010R$id.radioUnPublishRecept /*2131362750*/:
                Group group2 = (Group) this.this$0._$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
                Intrinsics.checkExpressionValueIsNotNull(group2, str);
                group2.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
