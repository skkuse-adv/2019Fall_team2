package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

final class StoreOptionSelectDialog$initializeView$6<T> implements Consumer<Boolean> {
    final /* synthetic */ StoreOptionSelectDialog this$0;

    StoreOptionSelectDialog$initializeView$6(StoreOptionSelectDialog storeOptionSelectDialog) {
        this.this$0 = storeOptionSelectDialog;
    }

    public final void accept(Boolean bool) {
        StoreOptionSelectDialog storeOptionSelectDialog = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        storeOptionSelectDialog.updateButtons(bool.booleanValue());
    }
}
