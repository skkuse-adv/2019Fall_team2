package kr.co.popone.fitts.feature.order;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.DiscountChoiceSelector;

final class OrderActivity$onCreate$30 implements OnTouchListener {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$30(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ((DiscountChoiceSelector) this.this$0._$_findCachedViewById(C0010R$id.discountSelector)).scrollViewFocusChanged();
        return false;
    }
}
