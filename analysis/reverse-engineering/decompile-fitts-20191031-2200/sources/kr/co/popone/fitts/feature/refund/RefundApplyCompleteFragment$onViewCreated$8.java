package kr.co.popone.fitts.feature.refund;

import android.widget.TableLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class RefundApplyCompleteFragment$onViewCreated$8<T> implements Observer<String> {
    final /* synthetic */ RefundApplyCompleteFragment this$0;

    RefundApplyCompleteFragment$onViewCreated$8(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        this.this$0 = refundApplyCompleteFragment;
    }

    public final void onChanged(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            String str2 = "textRefundCreditDesc";
            String str3 = "textRefundCreditCard";
            String str4 = "textRefundDeposit";
            String str5 = "tableBankInfo";
            if (hashCode != -900308920) {
                if (hashCode != -303793002) {
                    if (hashCode != 846974213 || !str.equals("kakaopay")) {
                        return;
                    }
                } else if (!str.equals("credit_card")) {
                    return;
                }
                TableLayout tableLayout = (TableLayout) this.this$0._$_findCachedViewById(C0010R$id.tableBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout, str5);
                ViewExtensionsKt.gone(tableLayout);
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundDeposit);
                Intrinsics.checkExpressionValueIsNotNull(textView, str4);
                ViewExtensionsKt.gone(textView);
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundCreditCard);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
                ViewExtensionsKt.visible(textView2);
                TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundCreditDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
                ViewExtensionsKt.visible(textView3);
            } else if (str.equals("direct_deposit")) {
                TableLayout tableLayout2 = (TableLayout) this.this$0._$_findCachedViewById(C0010R$id.tableBankInfo);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout2, str5);
                ViewExtensionsKt.visible(tableLayout2);
                TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundDeposit);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str4);
                ViewExtensionsKt.visible(textView4);
                TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundCreditCard);
                Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
                ViewExtensionsKt.gone(textView5);
                TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundCreditDesc);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str2);
                ViewExtensionsKt.gone(textView6);
            }
        }
    }
}
