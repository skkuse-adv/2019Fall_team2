package kr.co.popone.fitts.feature.event;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class AppliableEventApplyActivity$onCreate$2<T> implements Consumer<String> {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$2(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void accept(String str) {
        boolean z = true;
        if (AppliableEventApplyActivity.access$getParameters$p(this.this$0).getItems().size() > 1) {
            Intrinsics.checkExpressionValueIsNotNull(str, "it");
            if (str.length() <= 0) {
                z = false;
            }
            String str2 = "productMultiNameTextView";
            if (z) {
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.productMultiNameTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView, str2);
                textView.setText(str);
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.productMultiNameTextView)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray6));
                return;
            }
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.productMultiNameTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
            textView2.setText("상품 종류를 먼저 선택해주세요");
            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.productMultiNameTextView)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        }
    }
}
