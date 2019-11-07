package kr.co.popone.fitts.feature.reward;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class RewardPointUseActivity$onCreate$8<T> implements Consumer<CharSequence> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$8(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(CharSequence charSequence) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoWordCountTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "shippingMemoWordCountTextView");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence.length());
        sb.append("/50");
        textView.setText(sb.toString());
    }
}
