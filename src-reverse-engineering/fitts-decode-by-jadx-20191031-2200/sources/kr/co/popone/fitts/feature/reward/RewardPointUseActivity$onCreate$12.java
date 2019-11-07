package kr.co.popone.fitts.feature.reward;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.utils.IntExtensionsKt;

final class RewardPointUseActivity$onCreate$12<T> implements Consumer<Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$12(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(Pair<Integer, Integer> pair) {
        int intValue = ((Number) pair.getFirst()).intValue() + ((Number) pair.getSecond()).intValue();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.totalPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "totalPriceTextView");
        textView.setText(IntExtensionsKt.commaString(intValue));
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.priceErrorMessageTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "priceErrorMessageTextView");
        textView2.setVisibility(intValue > this.this$0.rewardPoints ? 0 : 4);
    }
}
