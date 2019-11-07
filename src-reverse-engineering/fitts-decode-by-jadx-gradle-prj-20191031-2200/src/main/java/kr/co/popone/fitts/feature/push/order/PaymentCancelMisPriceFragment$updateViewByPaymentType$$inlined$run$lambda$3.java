package kr.co.popone.fitts.feature.push.order;

import android.widget.EditText;
import android.widget.TextView.BufferType;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.remote.model.RefundAccount;

final class PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$3<T> implements Observer<RefundAccount> {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$3(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final void onChanged(RefundAccount refundAccount) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editBankName);
        if (refundAccount == null) {
            Intrinsics.throwNpe();
        }
        editText.setText(refundAccount.getBankName(), BufferType.EDITABLE);
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountHolder)).setText(refundAccount.getAccountHolder(), BufferType.EDITABLE);
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber)).setText(refundAccount.getAccountNumber(), BufferType.EDITABLE);
    }
}
