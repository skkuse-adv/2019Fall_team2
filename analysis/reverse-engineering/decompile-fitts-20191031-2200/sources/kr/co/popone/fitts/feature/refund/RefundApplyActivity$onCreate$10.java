package kr.co.popone.fitts.feature.refund;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

final class RefundApplyActivity$onCreate$10<T> implements Observer<String> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$10(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(@Nullable String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            String str2 = "textBankInfo";
            String str3 = "layoutInputDeposit";
            String str4 = "editAccountNumber";
            String str5 = "textPaymentRefunDesc";
            if (hashCode != -900308920) {
                if (hashCode != -303793002) {
                    if (hashCode != 846974213 || !str.equals("kakaopay")) {
                        return;
                    }
                } else if (!str.equals("credit_card")) {
                    return;
                }
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textPaymentRefunDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView, str5);
                textView.setVisibility(0);
                EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
                Intrinsics.checkExpressionValueIsNotNull(editText, str4);
                editText.setVisibility(8);
                LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutInputDeposit);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, str3);
                linearLayout.setVisibility(8);
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
                textView2.setVisibility(8);
            } else if (str.equals("direct_deposit")) {
                TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textPaymentRefunDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str5);
                textView3.setVisibility(8);
                EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
                Intrinsics.checkExpressionValueIsNotNull(editText2, str4);
                editText2.setVisibility(0);
                LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutInputDeposit);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str3);
                linearLayout2.setVisibility(0);
                TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
                textView4.setVisibility(0);
            }
        }
    }
}
