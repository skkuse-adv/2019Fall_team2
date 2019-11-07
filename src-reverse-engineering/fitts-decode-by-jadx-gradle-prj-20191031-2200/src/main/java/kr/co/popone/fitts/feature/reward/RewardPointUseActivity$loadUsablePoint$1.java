package kr.co.popone.fitts.feature.reward;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.IntExtensionsKt;

final class RewardPointUseActivity$loadUsablePoint$1<T> implements Consumer<MyInfo> {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$loadUsablePoint$1(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void accept(MyInfo myInfo) {
        this.this$0.rewardPoints = myInfo.getRewardPoints();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.availableRewardTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "availableRewardTextView");
        textView.setText(IntExtensionsKt.commaString(myInfo.getRewardPoints()));
    }
}
