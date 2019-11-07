package kr.co.popone.fitts.feature.cart;

import android.widget.CheckBox;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.event.CartEvent$OrderButtonClickEvent;
import kr.co.popone.fitts.event.CartEvent$VariantCheckStateChangeEvent;
import kr.co.popone.fitts.event.CartEvent$VariantsEditEvent;
import kr.co.popone.fitts.event.CartEvent$VariantsRemoveEvent;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;

final class CartActivity$onCreate$21<T> implements Consumer<Object> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$21(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof CartEvent$VariantsEditEvent) {
            CartEvent$VariantsEditEvent cartEvent$VariantsEditEvent = (CartEvent$VariantsEditEvent) obj;
            this.this$0.getViewModel().updateVariantsDetail(cartEvent$VariantsEditEvent.getVariantId(), cartEvent$VariantsEditEvent.getCount());
        } else if (obj instanceof CartEvent$VariantsRemoveEvent) {
            this.this$0.showDeleteConfirmDialog(((CartEvent$VariantsRemoveEvent) obj).getVariantId());
        } else if (obj instanceof CartEvent$VariantCheckStateChangeEvent) {
            this.this$0.calculateTotalPrice();
            CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(C0010R$id.checkAll);
            Intrinsics.checkExpressionValueIsNotNull(checkBox, "checkAll");
            checkBox.setChecked(this.this$0.cartAdatper.isAllVariantsChecked());
        } else if (obj instanceof CartEvent$OrderButtonClickEvent) {
            if (!this.this$0.hasOrderableItems()) {
                this.this$0.showEmptyOrderableItemsDialog();
            } else {
                this.this$0.makeOrder();
            }
        } else if (obj instanceof OrderEvent$OrderCompleteEvent) {
            this.this$0.finish();
        }
    }
}
