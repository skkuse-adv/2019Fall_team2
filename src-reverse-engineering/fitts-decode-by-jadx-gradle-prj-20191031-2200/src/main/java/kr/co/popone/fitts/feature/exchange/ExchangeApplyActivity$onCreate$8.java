package kr.co.popone.fitts.feature.exchange;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

final class ExchangeApplyActivity$onCreate$8<T> implements Observer<String> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$8(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(@Nullable String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            String str2 = "textBankInfo";
            String str3 = "textExchangeDesc";
            String str4 = "layoutInputDeposit";
            String str5 = "editAccountNumber";
            String str6 = "textPaymentRefunDesc";
            if (hashCode != -900308920) {
                if (hashCode != -303793002) {
                    if (hashCode != 846974213 || !str.equals("kakaopay")) {
                        return;
                    }
                } else if (!str.equals("credit_card")) {
                    return;
                }
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textPaymentRefunDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView, str6);
                textView.setVisibility(0);
                EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
                Intrinsics.checkExpressionValueIsNotNull(editText, str5);
                editText.setVisibility(8);
                LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutInputDeposit);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, str4);
                linearLayout.setVisibility(8);
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
                textView2.setVisibility(8);
                TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
                textView3.setVisibility(8);
            } else if (str.equals("direct_deposit")) {
                TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textPaymentRefunDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str6);
                textView4.setVisibility(8);
                EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
                Intrinsics.checkExpressionValueIsNotNull(editText2, str5);
                editText2.setVisibility(0);
                LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutInputDeposit);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str4);
                linearLayout2.setVisibility(0);
                TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
                textView5.setVisibility(0);
                TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str2);
                textView6.setVisibility(0);
            }
        }
    }
}
