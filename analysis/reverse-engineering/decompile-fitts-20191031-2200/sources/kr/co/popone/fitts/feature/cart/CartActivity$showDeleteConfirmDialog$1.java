package kr.co.popone.fitts.feature.cart;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CartActivity$showDeleteConfirmDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $variantId;
    final /* synthetic */ CartActivity this$0;

    CartActivity$showDeleteConfirmDialog$1(CartActivity cartActivity, long j) {
        this.this$0 = cartActivity;
        this.$variantId = j;
        super(0);
    }

    public final void invoke() {
        this.this$0.getViewModel().removeVariantsDetail(this.$variantId);
    }
}
