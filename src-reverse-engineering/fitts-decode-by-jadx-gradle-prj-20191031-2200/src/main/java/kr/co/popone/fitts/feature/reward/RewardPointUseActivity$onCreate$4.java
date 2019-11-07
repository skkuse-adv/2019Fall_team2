package kr.co.popone.fitts.feature.reward;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class RewardPointUseActivity$onCreate$4<T> implements Consumer<Boolean> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$4(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.showUrlLinkButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "showUrlLinkButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        button.setEnabled(bool.booleanValue());
    }
}
