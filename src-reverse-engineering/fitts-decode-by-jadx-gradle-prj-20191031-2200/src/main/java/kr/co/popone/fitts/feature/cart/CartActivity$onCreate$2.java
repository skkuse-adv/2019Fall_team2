package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import kr.co.popone.fitts.C0010R$id;

final class CartActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$2(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onClick(View view) {
        CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(C0010R$id.checkAll);
        checkBox.setChecked(!checkBox.isChecked());
        this.this$0.cartAdatper.updateAllCheckBox(checkBox.isChecked(), new CartActivity$onCreate$2$$special$$inlined$run$lambda$1(this));
    }
}
