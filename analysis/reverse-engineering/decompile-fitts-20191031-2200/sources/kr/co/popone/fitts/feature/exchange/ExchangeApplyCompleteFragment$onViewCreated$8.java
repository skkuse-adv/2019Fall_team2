package kr.co.popone.fitts.feature.exchange;

import android.widget.TableLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class ExchangeApplyCompleteFragment$onViewCreated$8<T> implements Observer<String> {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$8(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onChanged(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            String str2 = "textExchangeCreditDesc";
            String str3 = "textExchangeCreditCard";
            String str4 = "tableBankInfo";
            String str5 = "textExchangeDesc";
            String str6 = "textExchangeDeposit";
            if (hashCode != -900308920) {
                if (hashCode != -303793002) {
                    if (hashCode != 846974213 || !str.equals("kakaopay")) {
                        return;
                    }
                } else if (!str.equals("credit_card")) {
                    return;
                }
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDeposit);
                Intrinsics.checkExpressionValueIsNotNull(textView, str6);
                textView.setVisibility(8);
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str5);
                textView2.setVisibility(8);
                TableLayout tableLayout = (TableLayout) this.this$0._$_findCachedViewById(C0010R$id.tableBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout, str4);
                tableLayout.setVisibility(8);
                TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeCreditCard);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
                ViewExtensionsKt.visible(textView3);
                TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeCreditDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str2);
                ViewExtensionsKt.visible(textView4);
            } else if (str.equals("direct_deposit")) {
                TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDeposit);
                Intrinsics.checkExpressionValueIsNotNull(textView5, str6);
                textView5.setVisibility(0);
                TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str5);
                textView6.setVisibility(0);
                TableLayout tableLayout2 = (TableLayout) this.this$0._$_findCachedViewById(C0010R$id.tableBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout2, str4);
                tableLayout2.setVisibility(0);
                TextView textView7 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeCreditCard);
                Intrinsics.checkExpressionValueIsNotNull(textView7, str3);
                ViewExtensionsKt.gone(textView7);
                TextView textView8 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textExchangeCreditDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView8, str2);
                ViewExtensionsKt.gone(textView8);
            }
        }
    }
}
