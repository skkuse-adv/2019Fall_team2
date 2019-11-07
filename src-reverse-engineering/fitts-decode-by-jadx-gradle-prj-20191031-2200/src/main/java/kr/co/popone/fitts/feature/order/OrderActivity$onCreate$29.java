package kr.co.popone.fitts.feature.order;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class OrderActivity$onCreate$29 implements OnClickListener {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$29(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onClick(View view) {
        CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(C0010R$id.checkEqualInfo);
        String str = "checkEqualInfo";
        Intrinsics.checkExpressionValueIsNotNull(checkBox, str);
        CheckBox checkBox2 = (CheckBox) this.this$0._$_findCachedViewById(C0010R$id.checkEqualInfo);
        Intrinsics.checkExpressionValueIsNotNull(checkBox2, str);
        checkBox.setChecked(!checkBox2.isChecked());
    }
}
